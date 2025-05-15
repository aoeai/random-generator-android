package com.aoeai.rg.twelve_zodiac_signs.view_model

import androidx.lifecycle.ViewModel
import com.aoeai.rg.twelve_zodiac_signs.data.service.TwelveZodiacSignsCreator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TwelveZodiacSignsViewModel : ViewModel() {
    private val _zodiacImageId = MutableStateFlow(TwelveZodiacSignsCreator.randomImageId())
    val zodiacImageId: StateFlow<Int> = _zodiacImageId.asStateFlow()

    fun generateRandomZodiac() {
        _zodiacImageId.value = TwelveZodiacSignsCreator.randomImageId()
    }
}