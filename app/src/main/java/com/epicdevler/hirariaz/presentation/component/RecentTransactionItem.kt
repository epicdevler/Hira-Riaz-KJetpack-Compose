package com.epicdevler.hirariaz.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.epicdevler.hirariaz.R
import com.epicdevler.hirariaz.presentation.ui.theme.BlueGray
import com.epicdevler.hirariaz.utils.TransactionModel
import com.epicdevler.hirariaz.utils.TransactionType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentTransactionItem(
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
                painter = when (transactionModel!!.type) {
                    TransactionType.Sent -> painterResource(id = R.drawable.ic_arrow_up)
                    TransactionType.Received -> painterResource(id = R.drawable.ic_arrow_down)
                    TransactionType.Loan -> painterResource(id = R.drawable.ic_dollar)
                    TransactionType.Payment -> painterResource(id = R.drawable.ic_mail_open)
                },
                contentDescription = "${transactionModel.type} Icon",
                tint = BlueGray,
                modifier = Modifier
                    .padding(10.dp)
                    .size(30.dp)
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
                    color = BlueGray,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}