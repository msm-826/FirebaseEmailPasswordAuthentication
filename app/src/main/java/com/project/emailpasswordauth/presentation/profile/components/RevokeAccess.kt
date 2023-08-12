package com.project.emailpasswordauth.presentation.profile.components

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.components.ProgressBar
import com.project.emailpasswordauth.domain.model.Response
import com.project.emailpasswordauth.presentation.profile.ProfileViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun RevokeAccess(
    viewModel: ProfileViewModel = hiltViewModel(),
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope,
    signOut: () -> Unit
) {

    fun showRevokeAccessMessage() = coroutineScope.launch {
        val result = snackbarHostState.showSnackbar(
            message = "You need to re-authenticate before revoking the access.",
            actionLabel = "Sign out"
        )

        if (result == SnackbarResult.ActionPerformed) {
            signOut()
        }
    }

    when (val revokeAccessResponse = viewModel.revokeAccessResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> {
            val isAccessRevoked = revokeAccessResponse.data
            LaunchedEffect(isAccessRevoked) {
                if (isAccessRevoked) {
                    Log.d("ctag", "access revoked")
                }
            }
        }
        is Response.Failure -> revokeAccessResponse.apply {
            LaunchedEffect(e) {
                print(e)
                if (e.message == "This operation is sensitive and requires recent authentication. Log in again before retrying this request.") {
                    showRevokeAccessMessage()
                }
            }
        }
    }
}