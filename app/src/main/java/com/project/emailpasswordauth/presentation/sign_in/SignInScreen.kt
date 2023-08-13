package com.project.emailpasswordauth.presentation.sign_in

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.Utils.Companion.showMessage
import com.project.emailpasswordauth.presentation.sign_in.components.SignIn
import com.project.emailpasswordauth.presentation.sign_in.components.SignInContent
import com.project.emailpasswordauth.presentation.sign_in.components.SignInTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {

    val context = LocalContext.current

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

    SignIn(
        showErrorMessage = { errorMessage ->
            showMessage(context, errorMessage)
        }
    )
}