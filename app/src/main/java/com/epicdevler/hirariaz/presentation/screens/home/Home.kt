package com.epicdevler.hirariaz.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.epicdevler.hirariaz.R
import com.epicdevler.hirariaz.presentation.component.HSpacer
import com.epicdevler.hirariaz.presentation.ui.theme.Indigo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navController: NavController? = null,
) {
    val navItems = arrayListOf(
        NavigationItem(title = "Home", icon = Icons.Rounded.Home),
        NavigationItem(title = "Transactions", icon = Icons.Rounded.Info),
        NavigationItem(title = "Wallet", icon = Icons.Rounded.Lock),
        NavigationItem(title = "Profile", icon = Icons.Rounded.Email),
    )
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {
        Column(
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
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(
                        0.7F
                    )) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "$8900",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.W400,
                                color = Indigo
                            )
                            HSpacer(height = 5)
                            Text(
                                text = "Income",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }
                        Divider(modifier = Modifier.fillMaxHeight().width(1.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "$5500",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.W400,
                                color = Indigo
                            )
                            HSpacer(height = 5)
                            Text(
                                text = "Expenses",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                "$890",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.W400,
                                color = Indigo
                            )
                            HSpacer(height = 5)
                            Text(
                                text = "Loan",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }
                    }
                }
            }
        }
        NavigationBar(containerColor = Color.Transparent, modifier = Modifier.height(56.dp)) {
            repeat(navItems.size) { index ->
                val item = navItems[index]
                NavigationBarItem(
                    selected = false,
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.DarkGray.copy(alpha = 0.9F)
                    ),
                    onClick = { /*TODO*/ }, icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    }, alwaysShowLabel = false
                )
            }
        }
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