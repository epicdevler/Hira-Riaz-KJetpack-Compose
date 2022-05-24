package com.epicdevler.hirariaz.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.epicdevler.hirariaz.R
import com.epicdevler.hirariaz.presentation.component.CustonBottomBar
import com.epicdevler.hirariaz.presentation.component.HSpacer
import com.epicdevler.hirariaz.presentation.component.TransactionItem
import com.epicdevler.hirariaz.presentation.component.VSpacer
import com.epicdevler.hirariaz.presentation.ui.theme.BlueGray
import com.epicdevler.hirariaz.presentation.ui.theme.Indigo
import com.epicdevler.hirariaz.utils.TransactionModel
import com.epicdevler.hirariaz.utils.TransactionType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navController: NavController? = null,
) {
    val transactionItems = arrayListOf(
        TransactionModel(
            type = TransactionType.Sent,
            info = "Sending Payment to Clients",
            cost = "150",
            currencySign = "$"
        ),
        TransactionModel(
            type = TransactionType.Received,
            info = "Receiving Salary from company",
            cost = "250",
            currencySign = "$"
        ),
        TransactionModel(
            type = TransactionType.Loan,
            info = "Loan for the Car",
            cost = "150",
            currencySign = "$"
        ),
    )
    val navItems = arrayListOf(
        NavigationItem(title = "Home", icon = Icons.Rounded.Home),
        NavigationItem(title = "Transactions", icon = Icons.Rounded.Info),
        NavigationItem(title = "Wallet", icon = Icons.Rounded.Lock),
        NavigationItem(title = "Profile", icon = Icons.Rounded.Email),
    )
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {
        /*Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            ElevatedCard(
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White,
                ),
                elevation = CardDefaults.outlinedCardElevation(
                    defaultElevation = 22.dp,
                ),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(
                            onClick = {},
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_menu),
                                contentDescription = "Menu Icon"
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_more_vert),
                                contentDescription = "More Vert Icon"
                            )
                        }
                    }
                    Text(
                        "Hira Riaz",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Indigo
                    )
                    HSpacer(height = 5)
                    Text(
                        text = "UI/UX Designer",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.W400,
                    )
                    HSpacer(height = 40)
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                            .fillMaxWidth(
                                0.7F
                            )
                            .height(IntrinsicSize.Min)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "$8900",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.W400,
                                color = BlueGray
                            )
                            HSpacer(height = 5)
                            Text(
                                text = "Income",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(width = 1.dp), color = Color.Black.copy(alpha = 0.2F)
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "$5500",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.W400,
                                color = BlueGray
                            )
                            HSpacer(height = 5)
                            Text(
                                text = "Expenses",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(width = 1.dp), color = Color.Black.copy(alpha = 0.2F)
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "$890",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.W400,
                                color = BlueGray
                            )
                            HSpacer(height = 5)
                            Text(
                                text = "Loan",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }
                        HSpacer()
                    }
                }
            }
            HSpacer(30)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Overview",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Indigo
                    )
                    VSpacer(10)
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notification icon"
                    )
                }
                Text(
                    "Sept 13, 2022",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = BlueGray
                )
            }
        }*/
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            item {
                ElevatedCard(
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color.White,
                    ),
                    elevation = CardDefaults.outlinedCardElevation(
                        defaultElevation = 22.dp,
                    ),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            IconButton(
                                onClick = {},
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_menu),
                                    contentDescription = "Menu Icon"
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_more_vert),
                                    contentDescription = "More Vert Icon"
                                )
                            }
                        }
                        Text(
                            "Hira Riaz",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold,
                            color = Indigo
                        )
                        HSpacer(height = 5)
                        Text(
                            text = "UI/UX Designer",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.W400,
                        )
                        HSpacer(height = 40)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                                .fillMaxWidth(
                                    0.7F
                                )
                                .height(IntrinsicSize.Min)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "$8900",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.W400,
                                    color = BlueGray
                                )
                                HSpacer(height = 5)
                                Text(
                                    text = "Income",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.W400,
                                )
                            }
                            Divider(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(width = 1.dp), color = Color.Black.copy(alpha = 0.2F)
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "$5500",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.W400,
                                    color = BlueGray
                                )
                                HSpacer(height = 5)
                                Text(
                                    text = "Expenses",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.W400,
                                )
                            }
                            Divider(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(width = 1.dp), color = Color.Black.copy(alpha = 0.2F)
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "$890",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.W400,
                                    color = BlueGray
                                )
                                HSpacer(height = 5)
                                Text(
                                    text = "Loan",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.W400,
                                )
                            }
                            HSpacer()
                        }
                    }
                }
                HSpacer(10)
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "Overview",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold,
                            color = Indigo
                        )
                        VSpacer(10)
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notification icon"
                        )
                    }
                    Text(
                        "Sept 13, 2022",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = BlueGray
                    )
                }
                HSpacer(10)
            }
            items(transactionItems) { item ->
                TransactionItem(item)
            }
            item { HSpacer() }
        }
//        TODO: UPDATE BOTTOM NAVIGATION STYLE
        CustonBottomBar()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    Home()
}

data class NavigationItem(
    val icon: ImageVector,
    val title: String
)