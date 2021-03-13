package com.sudhindra.bloom.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.sudhindra.bloom.R
import com.sudhindra.bloom.models.GardenTheme
import com.sudhindra.bloom.models.ThemeInfo
import com.sudhindra.bloom.ui.components.GardenThemeCard
import com.sudhindra.bloom.ui.components.ThemeCard

val browsThemes = listOf(
    ThemeInfo(
        "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "Desert chic"
    ),
    ThemeInfo(
        "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "Tiny terrariums"
    ),
    ThemeInfo(
        "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        "Jungle vibes"
    ),
    ThemeInfo(
        "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Easy care"
    ),
    ThemeInfo(
        "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Statements"
    )
)

val homeGardenThemes = listOf(
    GardenTheme(
        "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Monstera",
        "This is a description",
        true
    ),
    GardenTheme(
        "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Aglonema",
        "This is a description",
        false
    ),
    GardenTheme(
        "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Peace lily",
        "This is a description",
        false
    ),
    GardenTheme(
        "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Fiddle leaf tree",
        "This is a description",
        false
    ),
    GardenTheme(
        "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Snake plant",
        "This is a description",
        false
    ),
    GardenTheme(
        "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        "Pothos",
        "This is a description",
        false
    ),
)

val homeMenu = listOf(
    "Home" to Icons.Filled.Home,
    "Favourites" to Icons.Filled.Favorite,
    "Profile" to Icons.Filled.Person,
    "Card" to Icons.Filled.ShoppingCart,
)

@Composable
fun Home() {
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.primary) {
                homeMenu.forEach { (label, icon) ->
                    BottomNavigationItem(
                        selected = (label == "Home"),
                        icon = { Icon(icon, contentDescription = "") },
                        label = {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.caption
                            )
                        },
                        onClick = {}
                    )
                }
            }
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text(text = "Search") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = ""
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
            )

            Text(
                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                text = "Browse themes",
                style = MaterialTheme.typography.h1
            )

            LazyRow {
                items(browsThemes) { item ->
                    ThemeCard(
                        themeInfo = item
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Discover your home garden",
                    style = MaterialTheme.typography.h1
                )
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(R.drawable.ic_filter), contentDescription = "")
                }
            }

            LazyColumn {
                items(homeGardenThemes + homeGardenThemes) { item ->
                    GardenThemeCard(item)
                }
            }
        }
    }
}
