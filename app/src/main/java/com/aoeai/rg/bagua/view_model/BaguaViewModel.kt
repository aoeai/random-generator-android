package com.aoeai.rg.bagua.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aoeai.rg.bagua.data.model.YaoCreator
import com.aoeai.rg.bagua.data.model.YaoDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BaguaViewModel : ViewModel() {
    private val _yaoList = MutableStateFlow<List<YaoDto>>(emptyList())
    val yaoList: StateFlow<List<YaoDto>> = _yaoList.asStateFlow()

    private val count = 6

    init {
        randomizeYao()
    }

    fun randomizeYao() {
        viewModelScope.launch {
            _yaoList.value = YaoCreator.randomList(count)
        }
    }
}