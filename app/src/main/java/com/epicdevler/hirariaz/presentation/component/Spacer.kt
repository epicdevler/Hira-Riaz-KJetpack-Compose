package com.epicdevler.hirariaz.presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
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
fun HSpacer(height: Int = 22) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun HDpSpacer(height: Dp = 22.dp) {
    Spacer(modifier = Modifier.height(height))
}