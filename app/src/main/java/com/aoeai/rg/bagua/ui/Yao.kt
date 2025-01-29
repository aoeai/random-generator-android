package com.aoeai.rg.bagua.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aoeai.rg.bagua.data.YaoCreator
import com.aoeai.rg.bagua.data.YaoDto
import com.aoeai.rg.common.ui.components.RandomButton
import com.aoeai.rg.common.ui.theme.rgBackground
import com.aoeai.rg.common.ui.theme.rgRandomButtonBottomPadding

@Composable
fun YaoView() {
    val count by remember { mutableIntStateOf(6) }
    var yaoDataList by remember { mutableStateOf(YaoCreator.randomList(count)) }

    Box(
        modifier = Modifier
            .rgBackground()
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        gua(yaoDataList)

        RandomButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .rgRandomButtonBottomPadding()
        ) {
            yaoDataList = YaoCreator.randomList(count)
        }
    }
}

@Composable
private fun gua(yaoDataList: List<YaoDto>) {
    LazyColumn(
        modifier = Modifier.size(300.dp)
            .testTag("guaLazyColumn"),
        verticalArrangement = Arrangement.Center,
    ) {
        items(yaoDataList) { yaoData ->
            Yao(yaoData = yaoData)
        }
    }
}

@Composable
private fun Yao(yaoData: YaoDto) {
    Row(modifier = Modifier.padding(all = 20.dp)) {
        // 3/7
        DrawLine(yaoData.edgeColor, modifier = Modifier.weight(3f))
        // 1/7
        DrawLine(yaoData.middleColor, modifier = Modifier.weight(1f))
        // 3/7
        DrawLine(yaoData.edgeColor, modifier = Modifier.weight(3f))
    }
}

@Composable
private fun DrawLine(color: Color, modifier: Modifier) {
    Canvas(modifier = modifier.fillMaxHeight()) {
        val startY = size.height / 2
        val endY = size.height / 2
        drawLine(
            color = color,
            start = Offset(0f, startY),
            end = Offset(size.width, endY),
            strokeWidth = 30f, // Increase the strokeWidth to make the line thicker
            alpha = 1f
        )
    }
}

@Preview(showBackground = true)
@Composable
fun YaoPreview() {
    YaoView()
}