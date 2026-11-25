package com.upchiapas.kt_demohilt.features.hardware.presentation.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upchiapas.kt_demohilt.features.hardware.domain.usescases.CaptureSingleResponseUseCase
import com.upchiapas.kt_demohilt.features.hardware.domain.usescases.ExecuteActuatorUseCase
import com.upchiapas.kt_demohilt.features.hardware.domain.usescases.GetGpsLocationStreamUseCase
import com.upchiapas.kt_demohilt.features.hardware.presentation.screens.HardwareUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HardwareViewModel @Inject constructor(
    private val getGpsLocationStreamUseCase: GetGpsLocationStreamUseCase,
    private val captureSingleResponseUseCase: CaptureSingleResponseUseCase,
    private val executeActuatorUseCase: ExecuteActuatorUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HardwareUIState())
    val uiState = _uiState.asStateFlow()

    private var gpsJob: Job? = null

    fun toggleGpsTracking() {
        if (_uiState.value.isGpsActive) {
            stopGpsTracking()
        } else {
            startGpsTracking()
        }
    }

    private fun startGpsTracking() {
        gpsJob?.cancel()
        _uiState.update { it.copy(isGpsActive = true, statusMessage = "Monitoreo GPS iniciado") }

        gpsJob = viewModelScope.launch {
            getGpsLocationStreamUseCase()
                .catch { error ->
                    _uiState.update {
                        it.copy(
                            isGpsActive = false,
                            error = error.localizedMessage ?: "Error al obtener flujo GPS"
                        )
                    }
                }
                .collect { location ->
                    _uiState.update {
                        it.copy(
                            gpsLocation = location,
                            error = null
                        )
                    }
                }
        }
    }

    fun stopGpsTracking() {
        gpsJob?.cancel()
        gpsJob = null
        _uiState.update { it.copy(isGpsActive = false, statusMessage = "Monitoreo GPS detenido") }
    }

    fun onTriggerActuator(durationMs: Long = 500L) {
        val result = executeActuatorUseCase(durationMs)
        result.fold(
            onSuccess = {
                _uiState.update {
                    it.copy(
                        statusMessage = "¡Actuador ejecutado correctamente!",
                        error = null
                    )
                }
            },
            onFailure = { error ->
                _uiState.update {
                    it.copy(
                        error = error.localizedMessage ?: "Error al ejecutar el actuador",
                        statusMessage = null
                    )
                }
            }
        )
    }

    fun onSingleResponseCapture() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = captureSingleResponseUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { response ->
                        currentState.copy(
                            isLoading = false,
                            singleResponse = response,
                            statusMessage = "Respuesta única capturada con éxito",
                            error = null
                        )
                    },
                    onFailure = { error ->
                        currentState.copy(
                            isLoading = false,
                            error = error.localizedMessage ?: "Error en captura de respuesta única",
                            statusMessage = null
                        )
                    }
                )
            }
        }
    }

    fun onPhotoCaptured(bitmap: Bitmap?) {
        if (bitmap != null) {
            _uiState.update {
                it.copy(
                    capturedImage = bitmap,
                    statusMessage = "Foto capturada exitosamente",
                    error = null
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    statusMessage = "Captura de foto cancelada",
                    error = null
                )
            }
        }
    }

    fun onCameraError(message: String) {
        _uiState.update {
            it.copy(
                error = message,
                statusMessage = null
            )
        }
    }

    fun clearMessages() {
        _uiState.update { it.copy(statusMessage = null, error = null) }
    }
}
