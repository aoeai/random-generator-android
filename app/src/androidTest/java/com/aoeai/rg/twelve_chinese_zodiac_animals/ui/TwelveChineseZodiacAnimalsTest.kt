package com.aoeai.rg.twelve_chinese_zodiac_animals.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.aoeai.rg.common.BaseComposeTest
import com.aoeai.rg.common.ComposeTools.Companion.randomRefreshButtonOf
import com.aoeai.rg.common.ComposeTools.Companion.textValueOf
import com.aoeai.rg.twelve_chinese_zodiac_animals.data.TwelveChineseZodiacAnimalsCreator.Companion.twelveChineseZodiacAnimals
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName

class TwelveChineseZodiacAnimalsTest : BaseComposeTest() {

    @Before
    fun setup() {
        rule.setContent { TwelveChineseZodiacAnimalsView() }
    }

    @DisplayName("随机十二生肖可以正常显示")
    @Test
    fun should_display_random_twelve_chinese_zodiac_animals_correctly() {
        val twelveChineseZodiacAnimalsText = twelveChineseZodiacAnimalsTextOf()

        twelveChineseZodiacAnimalsText.assertIsDisplayed()
    }

    @DisplayName("刷新按钮可以正常显示")
    @Test
    fun should_display_refresh_button_correctly() {
        val randomButton = randomRefreshButtonOf(rule)

        randomButton.assertIsDisplayed()
    }

    @DisplayName("点击刷新按钮后，生成的生肖在十二生肖列表中")
    @Test
    fun should_generate_a_zodiac_sign_from_the_chinese_zodiac_list_after_clicking_refresh_button() {
        val randomButton = randomRefreshButtonOf(rule)
        randomButton.performClick()

        val textValue = textValueOf(twelveChineseZodiacAnimalsTextOf())
        assertTrue(twelveChineseZodiacAnimals().contains(textValue)) { "Text value is not in the list of twelve Chinese zodiac animals" }
    }

    private fun twelveChineseZodiacAnimalsTextOf() =
        rule.onNodeWithTag("twelveChineseZodiacAnimalsText")
}