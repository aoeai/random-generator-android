package com.aoeai.rg.twelve_chinese_zodiac_animals.view_model

import androidx.lifecycle.ViewModel
import com.aoeai.rg.twelve_chinese_zodiac_animals.data.service.TwelveChineseZodiacAnimalsCreator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TwelveChineseZodiacAnimalsViewModel : ViewModel() {
    private val _signs = MutableStateFlow<List<String>>(emptyList())
    val signs: StateFlow<List<String>> = _signs.asStateFlow()

    init {
        generateSigns()
    }

    fun generateSigns() {
        _signs.value = TwelveChineseZodiacAnimalsCreator.randomList(1)
    }
}