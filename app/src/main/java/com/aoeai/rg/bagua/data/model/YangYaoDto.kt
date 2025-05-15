package com.aoeai.rg.bagua.data.model

import androidx.compose.ui.graphics.Color

@ConsistentCopyVisibility
data class YangYaoDto internal constructor(
    override val edgeColor: Color,
    override val middleColor: Color
) : YaoDto {
    override val value: Byte = 1
}
