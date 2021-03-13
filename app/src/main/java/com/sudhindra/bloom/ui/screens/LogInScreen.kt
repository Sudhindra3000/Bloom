package com.sudhindra.bloom.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.sudhindra.bloom.ui.components.SecondaryButton

@Composable
fun LogIn(
    navController: NavHostController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Log in with email",
            style = MaterialTheme.typography.h1
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(0.9f),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email Address") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(0.9f),
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password (8+ characters)") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .paddingFromBaseline(top = 24.dp, bottom = 16.dp),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle()) {
                    append("By clicking below, you agree to our ")
                }
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Terms of Use")
                }
                withStyle(style = SpanStyle()) {
                    append(" and consent to our ")
                }
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Privacy Policy")
                }
            },
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center
        )

        SecondaryButton(
            modifier = Modifier.fillMaxWidth(0.9f),
            onClick = { navController.navigate("home") }
        ) {
            Text(text = "Log in")
        }
    }
}
