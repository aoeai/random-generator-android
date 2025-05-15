package com.aoeai.rg.double_color_ball.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import com.aoeai.rg.common.ComposeTools.Companion.randomRefreshButtonOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class DoubleColorBallViewKtTest {
    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        rule.setContent { DoubleColorBallView() }
    }

    @DisplayName("红球区域显示 6 个球")
    @Test
    fun should_display_six_red_balls() {
        val indexes = 0..5
        indexes.forEachIndexed() { index, _ ->
            rule.onNodeWithTag("redBall$index").assertIsDisplayed()
        }
    }

    @DisplayName("蓝球区域显示1个球")
    @Test
    fun should_display_one_blue_ball() {
        val blueBall = rule.onNodeWithTag("blueBall")
        blueBall.assertIsDisplayed()

        // 验证蓝球数量为1个
        val blueBalls = rule.onAllNodesWithTag("blueBall")
        assert(blueBalls.fetchSemanticsNodes().size == 1) { "蓝球数量不是 1 个" }
    }

    @DisplayName("刷新按钮可以正常显示")
    @Test
    fun should_display_refresh_button_correctly() {
        val randomButton = randomRefreshButtonOf(rule)

        randomButton.assertIsDisplayed()
    }
}

