package com.aoeai.rg.number.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.aoeai.rg.common.ComposeTools.Companion.randomRefreshButtonOf
import com.aoeai.rg.common.ComposeTools.Companion.textValueOf
import com.aoeai.rg.number.view.NumberView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName

class NumberKtTest {
    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        rule.setContent { NumberView() }
    }

    @DisplayName("随机数字可以正常显示")
    @Test
    fun should_display_random_numbers_correctly() {
        val numberText = numberTextOf()

        numberText.assertIsDisplayed()
    }

    @DisplayName("刷新按钮可以正常显示")
    @Test
    fun should_display_refresh_button_correctly() {
        val randomButton = randomRefreshButtonOf(rule)

        randomButton.assertIsDisplayed()
    }

    @DisplayName("点击刷新按钮后，生成的随机数在0～9之间")
    @Test
    fun should_generate_random_numbers_between_0_and_9_after_clicking_refresh_button() {
        val randomButton = randomRefreshButtonOf(rule)
        randomButton.performClick()

        val textValue = textValueOf(numberTextOf())
        val numbers = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        assertTrue(numbers.contains(textValue)) { "Text value is not in the list of numbers" }
    }

    private fun numberTextOf() = rule.onNodeWithTag("numberText")
}