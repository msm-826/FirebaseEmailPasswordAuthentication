package com.project.emailpasswordauth.presentation.sign_up.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.components.ProgressBar
import com.project.emailpasswordauth.domain.model.Response
import com.project.emailpasswordauth.presentation.sign_up.SignUpViewModel

@Composable
fun SendEmailVerification(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    when (val sendEmailVerificationResponse = viewModel.sendEmailVerificationResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Failure -> sendEmailVerificationResponse.apply {
            LaunchedEffect(e) {
                print(e)
            }
        }
    }
}