package com.aoeai.rg.lottery_super_lotto.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aoeai.rg.lottery_super_lotto.data.service.LotteryDrawMachine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LotterySuperLottoViewModel : ViewModel() {
    // 前区号码状态
    private val _frontAreaBalls = MutableStateFlow(LotteryDrawMachine.drawFrontArea())
    val frontAreaBalls: StateFlow<List<Int>> = _frontAreaBalls.asStateFlow()

    // 后区号码状态
    private val _backAreaBalls = MutableStateFlow(LotteryDrawMachine.drawBackArea())
    val backAreaBalls: StateFlow<List<Int>> = _backAreaBalls.asStateFlow()

    // 随机生成新的号码
    fun generateNewBalls() {
        viewModelScope.launch {
            _frontAreaBalls.value = LotteryDrawMachine.drawFrontArea()
            _backAreaBalls.value = LotteryDrawMachine.drawBackArea()
        }
    }
}