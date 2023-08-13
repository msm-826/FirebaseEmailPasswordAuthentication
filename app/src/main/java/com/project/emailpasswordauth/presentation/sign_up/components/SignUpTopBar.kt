package com.project.emailpasswordauth.presentation.sign_up.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.project.emailpasswordauth.R
import com.project.emailpasswordauth.components.BackIcon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = stringResource(R.string.SIGN_UP_SCREEN)
            )
        },
        navigationIcon = {
            BackIcon(
                navigateBack = navigateBack
            )
        }
    )
}