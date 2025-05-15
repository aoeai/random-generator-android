package com.aoeai.rg.double_color_ball.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aoeai.rg.double_color_ball.data.service.LotteryDrawMachine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DoubleColorBallViewModel : ViewModel() {
    // 红球状态
    private val _redBalls = MutableStateFlow(LotteryDrawMachine.drawRedBalls())
    val redBalls: StateFlow<List<Int>> = _redBalls.asStateFlow()

    // 蓝球状态
    private val _blueBall = MutableStateFlow(LotteryDrawMachine.drawBlueBall())
    val blueBall: StateFlow<Int> = _blueBall.asStateFlow()

    // 随机生成新的双色球
    fun generateNewBalls() {
        viewModelScope.launch {
            _redBalls.value = LotteryDrawMachine.drawRedBalls()
            _blueBall.value = LotteryDrawMachine.drawBlueBall()
        }
    }
}