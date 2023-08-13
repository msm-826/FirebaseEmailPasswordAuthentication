package com.project.emailpasswordauth.presentation.forgot_password

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.R
import com.project.emailpasswordauth.Utils.Companion.showMessage
import com.project.emailpasswordauth.presentation.forgot_password.components.ForgotPassword
import com.project.emailpasswordauth.presentation.forgot_password.components.ForgotPasswordContent
import com.project.emailpasswordauth.presentation.forgot_password.components.ForgotPasswordTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    val context = LocalContext.current

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
            showMessage(context, context.getString(R.string.RESET_PASSWORD_MESSAGE))
        },
        showErrorMessage = {errorMessage ->
            showMessage(context,  errorMessage)
        }
    )
}