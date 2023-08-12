package com.project.emailpasswordauth.presentation.verify_email

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.components.TopBar
import com.project.emailpasswordauth.presentation.profile.ProfileViewModel
import com.project.emailpasswordauth.presentation.profile.components.RevokeAccess
import com.project.emailpasswordauth.presentation.verify_email.components.ReloadUser
import com.project.emailpasswordauth.presentation.verify_email.components.VerifyEmailContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyEmailScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToProfileScreen: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(
                title = "VERIFY_EMAIL_SCREEN",
                signOut = {
                    viewModel.signOut()
                },
                revokeAccess = {
                    viewModel.revokeAccess()
                }
            )
        },
        content = { padding ->
            VerifyEmailContent(
                padding = padding,
                reloadUser = {
                    viewModel.reloadUser()
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    )

    ReloadUser(
        navigateToProfileScreen = {
            if (viewModel.isEmailVerified) {
                navigateToProfileScreen()
            } else {
                Log.d("ctag", "Your email is not verified.")
            }
        }
    )

    RevokeAccess(
        snackbarHostState = snackbarHostState,
        coroutineScope = coroutineScope,
        signOut = {
            viewModel.signOut()
        }
    )
}