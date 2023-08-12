package com.project.emailpasswordauth.presentation.sign_up

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.presentation.sign_up.components.SendEmailVerification
import com.project.emailpasswordauth.presentation.sign_up.components.SignUp
import com.project.emailpasswordauth.presentation.sign_up.components.SignUpContent
import com.project.emailpasswordauth.presentation.sign_up.components.SignUpTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    Scaffold(
        topBar = {
            SignUpTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            SignUpContent(
                padding = padding,
                signUp = { email, password ->
                    viewModel.signUpWithEmailAndPassword(email, password)
                },
                navigateBack = navigateBack
            )
        }
    )

    SignUp(
        sendEmailVerification = {
            viewModel.sendEmailVerification()
        },
        showVerifyEmailMessage = {
            Log.d("ctag", "We've sent you an email with a link to verify the email.")
        }
    )

    SendEmailVerification()
}
