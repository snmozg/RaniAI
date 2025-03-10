package com.sozge.raniai.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ZodiacViewModel : ViewModel() {
    private val _selectedHoroscope = MutableStateFlow(0)
    val selectedHoroscope: StateFlow<Int> = _selectedHoroscope.asStateFlow()

    private val _selectedCardIndex = MutableStateFlow(0)
    val selectedCardIndex: StateFlow<Int> = _selectedCardIndex.asStateFlow()

    val horoscopes = listOf(
        "Koç", "Boğa", "İkizler", "Yengeç", "Aslan", "Başak",
        "Terazi", "Akrep", "Yay", "Oğlak", "Kova", "Balık"
    )

    val categories = listOf("Genel Özellikler", "Günlük Burç", "Takım Yıldızları")

    private val horoscopeDetails = mapOf(
        "Koç" to listOf("Koç'un özellikleri", "Koç'un günlük yorumu", "Koç'un takım yıldızı"),
        "Boğa" to listOf("Boğa'nın özellikleri", "Boğa'nın günlük yorumu", "Boğa'nın takım yıldızı"),
        "İkizler" to listOf("İkizler'in özellikleri", "İkizler'in günlük yorumu", "İkizler'in takım yıldızı"),
    )

    fun getCardContent(categoryIndex: Int): String {
        val selectedHoroscopeName = horoscopes[_selectedHoroscope.value]
        return horoscopeDetails[selectedHoroscopeName]?.get(categoryIndex) ?: "Bilinmiyor"
    }

    fun selectHoroscope(index: Int) {
        _selectedHoroscope.value = index
    }

    fun selectCard(index: Int) {
        _selectedCardIndex.value = index
    }
}