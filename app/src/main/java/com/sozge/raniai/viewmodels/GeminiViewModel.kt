package com.sozge.raniai.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sozge.raniai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GeminiViewModel : ViewModel() {
    private val _responseState = MutableStateFlow<String?>(null)
    val responseState: StateFlow<String?> = _responseState

    fun getGeminiData(prompt: String) {
        viewModelScope.launch {
            try {
                val generativeModel = GenerativeModel(
                    modelName = "gemini-1.5-flash",
                    apiKey = BuildConfig.API_KEY,
                    generationConfig = generationConfig {
                        temperature = 1f
                        topK = 40
                        topP = 0.95f
                        maxOutputTokens = 8192
                        responseMimeType = "text/plain"
                    }
                )
                val response = generativeModel.generateContent(prompt)
                println(response.text)
                _responseState.value = response.text
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun clearResponse() {
        _responseState.value = null
    }
}