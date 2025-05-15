package com.aoeai.rg.home.view_model

import androidx.lifecycle.ViewModel
import com.aoeai.rg.R
import com.aoeai.rg.bagua.view.BaguaActivity
import com.aoeai.rg.double_color_ball.view.DoubleColorBallActivity
import com.aoeai.rg.home.data.model.FunctionKeyDto
import com.aoeai.rg.lottery_super_lotto.view.LotterySuperLottoActivity
import com.aoeai.rg.number.view.NumberActivity
import com.aoeai.rg.twelve_chinese_zodiac_animals.view.TwelveChineseZodiacAnimalsActivity
import com.aoeai.rg.twelve_zodiac_signs.view.TwelveZodiacSignsActivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    // 功能键列表状态
    private val _functionKeys = MutableStateFlow(
        listOf(
            FunctionKeyDto(R.drawable.home_logo_bagua, BaguaActivity::class.java),
            FunctionKeyDto(R.drawable.home_logo_number_0_9, NumberActivity::class.java),
            FunctionKeyDto(
                R.drawable.home_logo_twelve_zodiac_signs,
                TwelveZodiacSignsActivity::class.java
            ),
            FunctionKeyDto(
                R.drawable.home_logo_twelve_chinese_zodiac_animals,
                TwelveChineseZodiacAnimalsActivity::class.java
            ),
            FunctionKeyDto(R.drawable.home_logo_double_color_ball, DoubleColorBallActivity::class.java),
            FunctionKeyDto(
                R.drawable.home_logo_lottery_super_lotto,
                LotterySuperLottoActivity::class.java
            ),
        )
    )

    // 暴露不可变的StateFlow供View层观察
    val functionKeys: StateFlow<List<FunctionKeyDto>> = _functionKeys.asStateFlow()
}