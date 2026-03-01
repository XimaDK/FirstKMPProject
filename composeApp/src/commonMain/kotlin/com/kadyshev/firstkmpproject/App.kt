package com.kadyshev.firstkmpproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kadyshev.firstkmpproject.loginScreen.LoginScreen
import com.kadyshev.firstkmpproject.navigation.Login
import com.kadyshev.firstkmpproject.navigation.Welcome
import com.kadyshev.firstkmpproject.welcomeScreen.WelcomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Welcome
        ) {
            composable<Welcome> {
                WelcomeScreen(
                    modifier = Modifier,
                    onClick = {
                        navController.navigate(Login)
                    }
                )
            }

            composable<Login> {
                LoginScreen(
                    modifier = Modifier,
                    onLoginClick = { _, _ ->
                    }
                )
            }
        }
    }
}