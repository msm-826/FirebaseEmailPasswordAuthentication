package com.project.emailpasswordauth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.emailpasswordauth.presentation.forgot_password.ForgotPasswordScreen
import com.project.emailpasswordauth.presentation.profile.ProfileScreen
import com.project.emailpasswordauth.presentation.sign_in.SignInScreen
import com.project.emailpasswordauth.presentation.sign_up.SignUpScreen
import com.project.emailpasswordauth.presentation.verify_email.VerifyEmailScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.SignInScreen.route
    ) {

        composable(
            route = Screen.SignInScreen.route
        ) {
            SignInScreen(
                navigateToForgotPasswordScreen = {
                    navController.navigate(Screen.ForgotPasswordScreen.route)
                },
                navigateToSignUpScreen = {
                    navController.navigate(Screen.SignUpScreen.route)
                }
            )
        }

        composable(
            route = Screen.ForgotPasswordScreen.route
        ) {
            ForgotPasswordScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.SignUpScreen.route
        ) {
            SignUpScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.VerifyEmailScreen.route
        ) {
            VerifyEmailScreen(
                navigateToProfileScreen = {
                    navController.navigate(Screen.ProfileScreen.route) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            route = Screen.ProfileScreen.route
        ) {
            ProfileScreen()
        }
    }
}