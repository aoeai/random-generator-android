package com.aoeai.rg.common

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag

class ComposeTools {

    companion object {
        fun randomRefreshButtonOf(rule: ComposeContentTestRule) = rule.onNodeWithTag("randomRefreshButton")

        fun textValueOf(node: SemanticsNodeInteraction): String {
            val semanticsNode = node.fetchSemanticsNode()
            return semanticsNode.config.getOrElse(SemanticsProperties.Text) { listOf() }
                .joinToString()
        }

    }
}