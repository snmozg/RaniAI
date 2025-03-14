package com.sozge.raniai.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sozge.raniai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class GeminiResponseState {
    object Idle : GeminiResponseState()
    object Loading : GeminiResponseState()
    data class Success(val text: String) : GeminiResponseState()
    data class Error(val message: String) : GeminiResponseState()
}

class GeminiViewModel : ViewModel() {
    private val _responseState = MutableStateFlow<GeminiResponseState>(GeminiResponseState.Idle)
    val responseState: StateFlow<GeminiResponseState> = _responseState

    fun getGeminiData(prompt: String) {
        viewModelScope.launch {
            try {
                _responseState.value = GeminiResponseState.Loading
                
                val generativeModel = GenerativeModel(
                    modelName = "gemini-1.5-flash",
                    apiKey = BuildConfig.API_KEY,
                    generationConfig = generationConfig {
                        temperature = 1f
                        topK = 40
                        topP = 0.95f
                        maxOutputTokens = 8192
                        responseMimeType = "application/json"
                    }
                )
                val response = generativeModel.generateContent(prompt)
                //println(response.text)
                response.text?.let {
                    _responseState.value = GeminiResponseState.Success(it)
                } ?: run {
                    _responseState.value = GeminiResponseState.Error("Boş yanıt alındı")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _responseState.value = GeminiResponseState.Error(e.message ?: "Bilinmeyen bir hata oluştu")
            }
        }
    }

    fun clearResponse() {
        _responseState.value = GeminiResponseState.Idle
    }
}