package com.aoeai.rg.about.view_model

import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.net.toUri
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AboutViewModel(application: Application) : AndroidViewModel(application) {

    private val _versionName = MutableStateFlow(getVersionName())
    val versionName: StateFlow<String> = _versionName.asStateFlow()

    private fun getVersionName(): String {
        return try {
            val context = getApplication<Application>()
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

    fun openUrl(url: String): Intent {
        return Intent(Intent.ACTION_VIEW, url.toUri())
    }

    fun gitHubIntent() = openUrl("https://github.com/aoeai/random-generator-android")

    fun giteeIntent() = openUrl("https://gitee.com/wyyl1/random-generator-android")
}