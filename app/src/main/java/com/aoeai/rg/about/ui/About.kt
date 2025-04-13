package com.aoeai.rg.about.ui

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.aoeai.rg.R
import com.aoeai.rg.common.ui.theme.GradientBrightGold
import com.aoeai.rg.common.ui.theme.rgBackground
import kotlinx.coroutines.launch

@Composable
fun About() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val versionName by remember { mutableStateOf(getVersionName(context)) }

    Box(
        modifier = Modifier
            .rgBackground()
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // App Icon
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "App Icon",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .shadow(8.dp)
            )

            // App Version
            Text(
                text = "Version $versionName",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(32.dp))

            // GitHub Button
            CommunicationButton(
                onClick = {
                    scope.launch {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            "https://github.com/aoeai/random-generator-android".toUri()
                        )
                        context.startActivity(intent)
                    }
                },
                logo = R.drawable.about_github_logo
            )
            // Gitee Button
            CommunicationButton(
                onClick = {
                    scope.launch {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            "https://gitee.com/wyyl1/random-generator-android".toUri()
                        )
                        context.startActivity(intent)
                    }
                },
                logo = R.drawable.about_gitee_logo
            )
        }
    }
}

private fun getVersionName(context: Context): String {
    return try {
        val packageManager = context.packageManager
        if (packageManager != null) {
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            packageInfo?.versionName ?: "1.0.0 (Preview)"
        } else {
            "1.0.0 (Preview)"
        }
    } catch (e: PackageManager.NameNotFoundException) {
        "Unknown"
    }
}

@Composable
private fun CommunicationButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    logo: Int
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        label = "buttonScale"
    )

    Button(
        onClick = {
            isPressed = true
            onClick()
            isPressed = false
        },
        modifier = modifier
            .width(240.dp)
            .height(48.dp)
            .scale(scale)
            .shadow(8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GradientBrightGold
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = logo),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .shadow(4.dp, RoundedCornerShape(16.dp))
            )
            Text(
                text = stringResource(id = R.string.menu_communication),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    About()
}
