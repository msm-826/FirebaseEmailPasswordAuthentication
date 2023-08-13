package com.project.emailpasswordauth.presentation.verify_email.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.Utils.Companion.logError
import com.project.emailpasswordauth.components.ProgressBar
import com.project.emailpasswordauth.domain.model.Response
import com.project.emailpasswordauth.presentation.profile.ProfileViewModel

@Composable
fun ReloadUser(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToProfileScreen: () -> Unit
) {
    when(val reloadUserResponse = viewModel.reloadUserResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> {
            val isUserReloaded = reloadUserResponse.data
            LaunchedEffect(isUserReloaded) {
                if (isUserReloaded) {
                    navigateToProfileScreen()
                }
            }
        }
        is Response.Failure -> reloadUserResponse.apply {
            LaunchedEffect(e) {
                logError(e)
            }
        }
    }
}