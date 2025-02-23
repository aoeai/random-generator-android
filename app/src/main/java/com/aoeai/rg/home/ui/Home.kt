package com.aoeai.rg.home.ui

import android.content.Intent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aoeai.rg.R
import com.aoeai.rg.bagua.BaguaActivity
import com.aoeai.rg.common.ui.theme.rgBackground
import com.aoeai.rg.double_color_ball.DoubleColorBallActivity
import com.aoeai.rg.home.data.FunctionKeyDto
import com.aoeai.rg.number.NumberActivity
import com.aoeai.rg.twelve_chinese_zodiac_animals.TwelveChineseZodiacAnimalsActivity
import com.aoeai.rg.twelve_zodiac_signs.TwelveZodiacSignsActivity

@Composable
fun Home() {
    val keys = listOf(
        FunctionKeyDto(R.drawable.home_logo_bagua, BaguaActivity::class.java),
        FunctionKeyDto(R.drawable.home_logo_number_0_9, NumberActivity::class.java),
        FunctionKeyDto(R.drawable.home_logo_twelve_zodiac_signs, TwelveZodiacSignsActivity::class.java),
        FunctionKeyDto(
            R.drawable.home_logo_twelve_chinese_zodiac_animals,
            TwelveChineseZodiacAnimalsActivity::class.java
        ),
        FunctionKeyDto(R.drawable.home_logo_double_color_ball, DoubleColorBallActivity::class.java),
    )

    Box(
        modifier = Modifier
            .rgBackground()
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(keys) { data ->
                    FunctionKey(data)
                }
            }
        )
    }
}

@Composable
private fun FunctionKey(data: FunctionKeyDto) {
    val packageContext = LocalContext.current
    val image = painterResource(data.resId)
    val isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.92f else 1f,
        animationSpec = tween(
            durationMillis = 100,
            easing = FastOutSlowInEasing
        ),
        label = "scale"
    )

    val cornerShape = RoundedCornerShape(16.dp)
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .scale(scale)
            .clip(cornerShape)
            .clickable(
                onClick = {
                    val intent = Intent(packageContext, data.targetActivityCls)
                    packageContext.startActivity(intent)
                }
            ),
        shape = cornerShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Home()
}