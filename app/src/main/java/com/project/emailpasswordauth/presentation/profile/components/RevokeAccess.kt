package com.project.emailpasswordauth.presentation.profile.components

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.R
import com.project.emailpasswordauth.Utils.Companion.logError
import com.project.emailpasswordauth.Utils.Companion.showMessage
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

    val context = LocalContext.current

    fun showRevokeAccessMessage() = coroutineScope.launch {
        val result = snackbarHostState.showSnackbar(
            message = context.getString(R.string.REVOKE_ACCESS_MESSAGE),
            actionLabel = context.getString(R.string.SIGN_OUT_ITEM)
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
                    showMessage(context, context.getString(R.string.ACCESS_REVOKED_MESSAGE))
                }
            }
        }
        is Response.Failure -> revokeAccessResponse.apply {
            LaunchedEffect(e) {
                logError(e)
                if (e.message == context.getString(R.string.SENSITIVE_OPERATION_MESSAGE)) {
                    showRevokeAccessMessage()
                }
            }
        }
    }
}