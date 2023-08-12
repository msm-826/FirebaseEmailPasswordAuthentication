package com.project.emailpasswordauth.presentation.sign_up.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.components.ProgressBar
import com.project.emailpasswordauth.domain.model.Response
import com.project.emailpasswordauth.presentation.sign_up.SignUpViewModel

@Composable
fun SignUp(
    viewModel: SignUpViewModel = hiltViewModel(),
    sendEmailVerification: () -> Unit,
    showVerifyEmailMessage: () -> Unit
) {
    when (val signUpResponse = viewModel.signUpResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> {
            val isUSerSignedUp = signUpResponse.data
            LaunchedEffect(isUSerSignedUp) {
                if (isUSerSignedUp) {
                    sendEmailVerification()
                    showVerifyEmailMessage()
                }
            }
        }
        is Response.Failure ->signUpResponse.apply {
            LaunchedEffect(e) {
                print(e)
            }
        }
    }
}