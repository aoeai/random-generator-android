package com.aoeai.rg.lottery_super_lotto.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.aoeai.rg.common.ComposeTools.Companion.randomRefreshButtonOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class LotterySuperLottoKtTest{
    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        rule.setContent { LotterySuperLottoView() }
    }

    @DisplayName("前区区域显示 5 个球")
    @Test
    fun should_display_five_front_area_balls() {
        val indexes = 0..4
        indexes.forEachIndexed() { index, _ ->
            rule.onNodeWithTag("frontBall$index").assertIsDisplayed()
        }
    }

    @DisplayName("后区区域显示 2 个球")
    @Test
    fun should_display_two_back_area_balls() {
        val indexes = 0..1
        indexes.forEachIndexed() { index, _ ->
            rule.onNodeWithTag("backBall$index").assertIsDisplayed()
        }
    }

    @DisplayName("刷新按钮可以正常显示")
    @Test
    fun should_display_refresh_button_correctly() {
        val randomButton = randomRefreshButtonOf(rule)

        randomButton.assertIsDisplayed()
    }
}

