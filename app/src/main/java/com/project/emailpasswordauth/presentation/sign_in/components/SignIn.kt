package com.project.emailpasswordauth.presentation.sign_in.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.Utils.Companion.logError
import com.project.emailpasswordauth.components.ProgressBar
import com.project.emailpasswordauth.domain.model.Response
import com.project.emailpasswordauth.presentation.sign_in.SignInViewModel

@Composable
fun SignIn(
    viewModel: SignInViewModel = hiltViewModel(),
    showErrorMessage: (errorMessage: String?) -> Unit
) {
    when(val signInResponse = viewModel.signInResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Failure -> signInResponse.apply {
            LaunchedEffect(e) {
                logError(e)
                showErrorMessage(e.message)
            }
        }
    }
}