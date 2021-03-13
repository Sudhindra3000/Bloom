package com.sudhindra.bloom.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.sudhindra.bloom.R
import com.sudhindra.bloom.ui.components.SecondaryButton

@Composable
fun Welcome(
    navController: NavHostController
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(top = 72.dp, start = 88.dp),
            painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.ic_dark_welcome_illos else R.drawable.ic_light_welcome_illos),
            contentDescription = ""
        )

        Image(
            modifier = Modifier.padding(top = 48.dp),
            painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.ic_dark_logo else R.drawable.ic_light_logo),
            contentDescription = "Logo"
        )
        Text(
            modifier = Modifier.paddingFromBaseline(top = 32.dp),
            text = "Beautiful Home Garden Solutions",
            style = MaterialTheme.typography.caption
        )

        SecondaryButton(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth(0.9f),
            onClick = {}
        ) {
            Text(text = "Create account")
        }

        TextButton(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(0.9f)
                .height(48.dp),
            onClick = { navController.navigate("logIn") },
            colors = ButtonDefaults.textButtonColors(
                contentColor = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colors.secondary
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Log in")
        }
    }
}
