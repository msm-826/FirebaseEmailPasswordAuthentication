package com.project.emailpasswordauth.presentation.forgot_password

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.presentation.forgot_password.components.ForgotPassword
import com.project.emailpasswordauth.presentation.forgot_password.components.ForgotPasswordContent
import com.project.emailpasswordauth.presentation.forgot_password.components.ForgotPasswordTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    Scaffold(
        topBar = {
            ForgotPasswordTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            ForgotPasswordContent(
                padding = padding,
                sendPasswordResetEmail = { email ->
                    viewModel.sendPasswordResetEmail(email)
                }
            )
        }
    )

    ForgotPassword(
        navigateBack = navigateBack,
        showResetPasswordMessage = {
            Log.d("ctag", "reset")
        },
        showErrorMessage = {
            Log.d("ctag", "error")
        }
    )
}