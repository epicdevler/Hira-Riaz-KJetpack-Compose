package com.epicdevler.hirariaz.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.epicdevler.hirariaz.R
import com.epicdevler.hirariaz.presentation.component.RecentTransactionItem
import com.epicdevler.hirariaz.presentation.ui.theme.Indigo
import com.epicdevler.hirariaz.utils.TransactionModel
import com.epicdevler.hirariaz.utils.TransactionType

enum class RecentTransactionsFilterOptions {
    All, Income, Expense
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalUnitApi::class)
@Composable
fun RecentTransactions(
    navController: NavController? = null
) {
    var filterOption = rememberSaveable {
        mutableStateOf(RecentTransactionsFilterOptions.All)
    }
    val chipItems = arrayListOf(
        RecentTransactionsFilterOptions.All,
        RecentTransactionsFilterOptions.Income,
        RecentTransactionsFilterOptions.Expense,
    )
    val items = rememberSaveable {
        mutableStateOf(
            listOf(
                TransactionModel(
                    type = TransactionType.Payment,
                    info = "Paytment from Andrea",
                    cost = "30.00",
                    currencySign = "$"
                ),
            )
        )
    }

    val typography = MaterialTheme.typography
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController?.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_left_arrow),
                            contentDescription = "Back Icon"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search Icon"
                        )
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Recent Transactions",
                        style = typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Indigo
                    )
                    TextButton({}) {
                        Text(
                            "See all",
                            style = typography.bodyMedium.copy(color = Color.DarkGray),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    items(items = chipItems) { item ->
                        ElevatedFilterChip(
                            selected = item == filterOption.value,
                            onClick = {
                                filterOption.value = item
                            },
                            label = { Text(text = item.toString()) },
                            shape = CircleShape,
                            colors = FilterChipDefaults.elevatedFilterChipColors(
                                containerColor = Color.White,
                                selectedContainerColor = Indigo,
                                selectedLabelColor = Color.White,
                                labelColor = Color.DarkGray
                            ),
                            elevation = FilterChipDefaults.elevatedFilterChipElevation(
                                defaultElevation = when (item) {
                                    filterOption.value -> 0.dp
                                    else -> 8.dp
                                }
                            )
                        )
                    }
                }
            }
            item {
                Text(
                    "Today",
                    style = typography.titleLarge,
                    fontWeight = FontWeight.Medium,
                    color = Indigo
                )
            }
            items(items = items.value) { item ->
                RecentTransactionItem(
                    transactionModel = item
                )
            }
        }
        ElevatedButton(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 30.dp)
                .fillMaxWidth(),
            onClick = {},
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Indigo,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(16.dp),
        ) {
            Text("See Details", fontSize = TextUnit(16F, TextUnitType.Sp))
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecentTransactionPreview() {
    RecentTransactions()
}