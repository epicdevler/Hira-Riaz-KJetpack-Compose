package com.epicdevler.hirariaz.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.epicdevler.hirariaz.presentation.ui.theme.Gray
import com.epicdevler.hirariaz.presentation.ui.theme.Indigo
import com.epicdevler.hirariaz.utils.InputFieldType

@OptIn(ExperimentalMaterial3Api::class, ExperimentalUnitApi::class)
@Composable
fun InputField(
    value: String,
    label: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    fieldType: InputFieldType = InputFieldType.Text,
    imeAction: ImeAction = ImeAction.Done,
) {
    val keyboardOptions: KeyboardOptions = when (fieldType) {
        is InputFieldType.Text -> KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Text
        )
        is InputFieldType.Email -> KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Email
        )
        is InputFieldType.Password -> KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Password
        )
    }
    val icon: ImageVector? = when (fieldType) {
        is InputFieldType.Text -> null
        is InputFieldType.Email -> Icons.Outlined.Email
        is InputFieldType.Password -> Icons.Outlined.Lock
//        is InputFieldType.Password -> Icon(painter = painterResource(id = R.drawable.ic_visibility), contentDescription = "Password Visibility")
    }
    val placeholder = when (fieldType) {
        is InputFieldType.Password -> "●●●●●●●"
        else -> placeHolder
    }

    ElevatedCard(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 22.dp
        ),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                label,
                fontSize = TextUnit(16F, TextUnitType.Sp),
                color = Gray,
                style = MaterialTheme.typography.bodySmall
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (icon != null) Icon(
                    imageVector = icon,
                    contentDescription = icon.name,
                )
                Input(
                    value = value, onValueChange = onValueChange,
                    placeholderText = placeholder,
                    keyboardOptions = keyboardOptions,
                    visualTransformation = when (fieldType) {
                        is InputFieldType.Password -> PasswordVisualTransformation(
                            mask = '\u25CF'
                        )
                        else -> VisualTransformation.None
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        placeholderColor = Color.Black,
                        textColor = Color.Black,
                    ),
                    textStyle = TextStyle(
                        fontSize = TextUnit(16F, TextUnitType.Sp)
                    ),
                    maxLines = 1,
                )
            }
        }
    }
}