package com.aoeai.rg.common.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.rgBackground() = this.background(brush = background())

@Composable
fun Modifier.rgRandomButtonBottomPadding() = this
    .padding(bottom = 32.dp)