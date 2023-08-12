package com.project.emailpasswordauth.presentation.sign_in

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.presentation.sign_in.components.SignInContent
import com.project.emailpasswordauth.presentation.sign_in.components.SignInTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {

    Scaffold (
        topBar = {
            SignInTopBar()
        },
        content = { padding ->
            SignInContent(
                padding =padding,
                signIn = { email, password ->
                    viewModel.signInWithEmailAndPassword(email, password)
                },
                navigateToForgotPasswordScreen = navigateToForgotPasswordScreen,
                navigateToSignUpScreen = navigateToSignUpScreen
            )
        }
    )
}