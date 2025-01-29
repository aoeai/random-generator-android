package com.aoeai.rg.common.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.aoeai.rg.common.ui.theme.GradientBrightGold
import com.aoeai.rg.common.ui.theme.GradientDarkGold

@Composable
fun RandomButton(modifier: Modifier, onClick: () -> Unit) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        animationSpec = tween(durationMillis = 100)
    )

    Brush.radialGradient(
        colors = listOf(
            GradientBrightGold,
            GradientDarkGold
        )
    )

    Button(
        modifier = modifier
            .testTag("randomRefreshButton")
            .clip(CircleShape)
            .size(100.dp)
            .padding(10.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                alpha = 0.99f  // 启用阴影效果
            },
        onClick = {
            isPressed = true
            onClick()
            isPressed = false
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFD700)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp,
            pressedElevation = 2.dp
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Refresh,
            contentDescription = "Random",
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
    }
}