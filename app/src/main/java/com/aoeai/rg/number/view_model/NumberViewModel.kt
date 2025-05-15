package com.aoeai.rg.number.view_model

import androidx.lifecycle.ViewModel
import com.aoeai.rg.number.data.service.NumberCreator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NumberViewModel : ViewModel() {
    private val _count = 1

    private val _numbers = MutableStateFlow<List<Int>>(emptyList())
    val numbers: StateFlow<List<Int>> = _numbers.asStateFlow()

    init {
        generateNumbers()
    }
    
    fun generateNumbers() {
        _numbers.value = NumberCreator.randomList(_count)
    }
}