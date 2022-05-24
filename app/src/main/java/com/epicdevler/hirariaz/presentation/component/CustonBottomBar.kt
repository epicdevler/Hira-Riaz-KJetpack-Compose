package com.epicdevler.hirariaz.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustonBottomBar(){
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Icon(imageVector = Icons.Rounded.Home, "")
        Icon(imageVector = Icons.Rounded.Home, "")
        Icon(imageVector = Icons.Rounded.Home, "")
        Icon(imageVector = Icons.Rounded.Home, "")
    }
}