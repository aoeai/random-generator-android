package com.aoeai.rg.bagua.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import com.aoeai.rg.common.BaseComposeTest
import com.aoeai.rg.common.ComposeTools.Companion.randomRefreshButtonOf
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class YaoKtTest : BaseComposeTest() {

    @Before
    fun setup() {
        rule.setContent { YaoView() }
    }

    @DisplayName("卦象可以正常显示")
    @Test
    fun should_display_the_gua_correctly() {
        val gua = rule.onNodeWithTag("guaLazyColumn")

        gua.assertIsDisplayed()
    }

    @DisplayName("刷新按钮可以正常显示")
    @Test
    fun should_display_refresh_button_correctly() {
        val randomButton = randomRefreshButtonOf(rule)

        randomButton.assertIsDisplayed()
    }
}