package com.sudhindra.bloom

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sudhindra.bloom.ui.screens.Home
import com.sudhindra.bloom.ui.screens.LogIn
import com.sudhindra.bloom.ui.screens.Welcome
import com.sudhindra.bloom.ui.theme.BloomTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "welcome") {
                        composable("welcome") { Welcome(navController) }
                        composable("logIn") { LogIn(navController) }
                        composable("home") { Home() }
                    }
                }
            }
        }
    }
}
