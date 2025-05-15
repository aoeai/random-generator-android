package com.aoeai.rg.twelve_zodiac_signs.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aoeai.rg.common.ui.components.RandomButton
import com.aoeai.rg.common.ui.theme.rgBackground
import com.aoeai.rg.common.ui.theme.rgRandomButtonBottomPadding
import com.aoeai.rg.twelve_zodiac_signs.view_model.TwelveZodiacSignsViewModel

@Composable
fun TwelveZodiacSignsView(viewModel: TwelveZodiacSignsViewModel = viewModel()) {
    val imageId by viewModel.zodiacImageId.collectAsState()

    Box(
        modifier = Modifier
            .rgBackground()
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ZodiacImage(imageId)

        RandomButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .rgRandomButtonBottomPadding()
        ) {
            viewModel.generateRandomZodiac()
        }
    }
}

@Composable
fun ZodiacImage(imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .size(300.dp)
            .testTag("twelveZodiacSignsImage")
    )
}

@Preview(showBackground = true)
@Composable
fun TwelveZodiacSignsPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        TwelveZodiacSignsView()
    }
}