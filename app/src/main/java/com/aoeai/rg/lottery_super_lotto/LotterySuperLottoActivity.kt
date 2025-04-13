package com.aoeai.rg.lottery_super_lotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aoeai.rg.lottery_super_lotto.ui.LotterySuperLottoView

class LotterySuperLottoActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LotterySuperLottoView()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    LotterySuperLottoView()
}