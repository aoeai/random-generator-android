package com.aoeai.rg.home.data.model

import androidx.compose.runtime.Immutable

@Immutable
data class FunctionKeyDto(
    val resId: Int,
    val targetActivityCls: Class<*>?
)