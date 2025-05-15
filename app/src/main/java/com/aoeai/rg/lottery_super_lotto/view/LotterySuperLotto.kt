package com.aoeai.rg.lottery_super_lotto.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aoeai.rg.common.ui.components.RandomButton
import com.aoeai.rg.common.ui.theme.rgBackground
import com.aoeai.rg.common.ui.theme.rgRandomButtonBottomPadding
import com.aoeai.rg.lottery_super_lotto.view_model.LotterySuperLottoViewModel

@Composable
fun LotterySuperLottoView(viewModel: LotterySuperLottoViewModel = viewModel()) {
    // 使用collectAsState从Flow中收集最新状态
    val frontAreaBalls by viewModel.frontAreaBalls.collectAsState()
    val backAreaBalls by viewModel.backAreaBalls.collectAsState()

    Box(
        modifier = Modifier
            .rgBackground()
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 左侧显示5个前区号码
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                frontAreaBalls.forEachIndexed { index, number ->
                    LotteryBall(
                        number = number,
                        gradient = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFFFF6B6B),
                                Color(0xFFFF0000)
                            )
                        ),
                        modifier = Modifier.testTag("frontBall$index")
                    )
                }
            }

            // 右侧显示2个后区号码
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                backAreaBalls.forEachIndexed { index, number ->
                    LotteryBall(
                        number = number,
                        gradient = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFF6B8AFF),
                                Color(0xFF0044FF)
                            )
                        ),
                        modifier = Modifier.testTag("backBall$index")
                    )
                }
            }
        }

        RandomButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .rgRandomButtonBottomPadding()
        ) {
            viewModel.generateNewBalls()
        }
    }
}

@Composable
private fun LotteryBall(
    number: Int,
    gradient: Brush,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(64.dp)
            .shadow(
                elevation = 8.dp,
                shape = CircleShape
            )
            .clip(CircleShape)
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NumberPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LotterySuperLottoView()
    }
}