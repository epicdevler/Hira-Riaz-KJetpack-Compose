package com.epicdevler.hirariaz.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VSpacer(
    width: Int = 22,
) {
    Spacer(
        modifier = Modifier.width(width.dp)
    )
}

@Composable
fun HSpacer(
    height: Int = 22,
) {
    Spacer(
        modifier = Modifier.height(height.dp)
    )
}