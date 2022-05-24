package com.epicdevler.hirariaz.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epicdevler.hirariaz.presentation.ui.theme.BlueGray
import com.epicdevler.hirariaz.presentation.ui.theme.Indigo
import com.epicdevler.hirariaz.utils.TransactionModel
import com.epicdevler.hirariaz.utils.TransactionType

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TransactionItem(
    transactionModel: TransactionModel? = null
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),

        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = Modifier
                    .background(
                        color = BlueGray.copy(alpha = .2F),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(10.dp),
                imageVector = when (transactionModel!!.type) {
                    TransactionType.Sent -> Icons.Rounded.KeyboardArrowDown
                    TransactionType.Received -> Icons.Rounded.KeyboardArrowDown
                    TransactionType.Loan -> Icons.Rounded.KeyboardArrowDown
                }, contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(.8F)
            ) {
                Text(
                    text = transactionModel.type.toString(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = transactionModel.info,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.DarkGray)
                )
            }
            Text(
                text = "${transactionModel.currencySign}${transactionModel.cost}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}