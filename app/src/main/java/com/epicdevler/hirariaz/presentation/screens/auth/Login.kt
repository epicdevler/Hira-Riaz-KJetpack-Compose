@file:OptIn(ExperimentalUnitApi::class)

package com.epicdevler.hirariaz.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.epicdevler.hirariaz.R
import com.epicdevler.hirariaz.presentation.component.HSpacer
import com.epicdevler.hirariaz.presentation.component.InputField
import com.epicdevler.hirariaz.presentation.ui.theme.Gray
import com.epicdevler.hirariaz.presentation.ui.theme.Indigo
import com.epicdevler.hirariaz.utils.InputFieldType
import com.epicdevler.hirariaz.utils.NavRoutes

@Composable
fun Login(
    navController: NavHostController?
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(22.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            colorFilter = ColorFilter.tint(color = Indigo),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )
        HSpacer(height = 100)
        InputField(
            value = email,
            onValueChange = { email = it },
            label = "Email Address",
            placeHolder = "Username@gmail.com",
            fieldType = InputFieldType.Email,
            imeAction = ImeAction.Next
        )
        HSpacer()
        InputField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            placeHolder = "●●●●●●●",
            fieldType = InputFieldType.Password,
            imeAction = ImeAction.Done
        )
        HSpacer()
        ElevatedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                      navController?.navigate(NavRoutes.Home.route)
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Indigo,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(16.dp),
        ) {
            Text("Login", fontSize = TextUnit(16F, TextUnitType.Sp))
        }
        HSpacer()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Signup",
                fontSize = TextUnit(16F, TextUnitType.Sp),
                color = Gray,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                "Forgot Password?",
                fontSize = TextUnit(16F, TextUnitType.Sp),
                color = Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}