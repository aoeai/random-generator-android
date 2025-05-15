package com.aoeai.rg.twelve_chinese_zodiac_animals.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aoeai.rg.common.ui.components.RandomButton
import com.aoeai.rg.common.ui.theme.rgBackground
import com.aoeai.rg.common.ui.theme.rgRandomButtonBottomPadding
import com.aoeai.rg.twelve_chinese_zodiac_animals.view_model.TwelveChineseZodiacAnimalsViewModel

@Composable
fun TwelveChineseZodiacAnimalsView(viewModel: TwelveChineseZodiacAnimalsViewModel = viewModel()) {
    val signs by viewModel.signs.collectAsState()

    Box(
        modifier = Modifier
            .rgBackground()
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.testTag("twelveChineseZodiacAnimalsText"),
            text = signs.joinToString(" "),
            fontSize = 200.sp,
            color = Color.Black,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 70.sp
        )

        RandomButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .rgRandomButtonBottomPadding()
        ) {
            viewModel.generateSigns()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TwelveChineseZodiacAnimalsPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        TwelveChineseZodiacAnimalsView()
    }
}