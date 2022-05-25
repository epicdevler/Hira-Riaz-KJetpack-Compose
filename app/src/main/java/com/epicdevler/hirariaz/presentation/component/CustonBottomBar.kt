package com.epicdevler.hirariaz.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.epicdevler.hirariaz.R
import com.epicdevler.hirariaz.presentation.ui.theme.Indigo
import com.epicdevler.hirariaz.utils.NavRoutes

@Composable
fun CustonBottomBar(navController: NavController?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id = R.drawable.ic_home), "", Modifier.size(24.dp))
        }
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id = R.drawable.ic_atm_card), "", Modifier.size(24.dp))
        }
        IconButton(
            onClick = { navController?.navigate(NavRoutes.Transaction.route) },
            Modifier
                .background(color = Indigo, shape = RoundedCornerShape(10.dp))
                .padding(6.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                "",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id = R.drawable.ic_dollar), "", Modifier.size(24.dp))
        }
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id = R.drawable.ic_user), "", Modifier.size(24.dp))
        }
    }
}