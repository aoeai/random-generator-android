package com.aoeai.rg.twelve_zodiac_signs.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.aoeai.rg.common.BaseComposeTest
import com.aoeai.rg.common.ComposeTools.Companion.randomRefreshButtonOf
import com.aoeai.rg.twelve_zodiac_signs.view.TwelveZodiacSignsView
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class TwelveZodiacSignsKtTest : BaseComposeTest() {

    @Before
    fun setup() {
        rule.setContent { TwelveZodiacSignsView() }
    }

    @DisplayName("十二星座图片可以正常显示")
    @Test
    fun should_display_twelve_zodiac_signs_image_correctly() {
        val twelveZodiacSignsImage = twelveZodiacSignsImageOf()

        twelveZodiacSignsImage.assertIsDisplayed()
    }

    @DisplayName("刷新按钮可以正常显示")
    @Test
    fun should_display_refresh_button_correctly() {
        val randomButton = randomRefreshButtonOf(rule)

        randomButton.assertIsDisplayed()
    }

    @DisplayName("点击刷新按钮后，生成的图片正常显示")
    @Test
    fun should_display_the_generated_image_correctly_after_clicking_refresh_button() {
        val randomButton = randomRefreshButtonOf(rule)
        randomButton.performClick()

        val imageNode = twelveZodiacSignsImageOf()
        imageNode.captureToImage()
    }

    private fun twelveZodiacSignsImageOf() =
        rule.onNodeWithTag("twelveZodiacSignsImage")
}