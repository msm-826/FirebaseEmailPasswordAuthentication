package com.project.emailpasswordauth.presentation.forgot_password.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.project.emailpasswordauth.R
import com.project.emailpasswordauth.components.BackIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = stringResource(R.string.FORGOT_PASSWORD_SCREEN)
            )
        },
        navigationIcon = {
            BackIcon(
                navigateBack = navigateBack
            )
        }
    )
}