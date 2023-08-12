package com.project.emailpasswordauth.presentation.profile

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.emailpasswordauth.components.TopBar
import com.project.emailpasswordauth.presentation.profile.components.ProfileContent
import com.project.emailpasswordauth.presentation.profile.components.RevokeAccess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(
                title = "Profile Screen",
                signOut = { viewModel.signOut() },
                revokeAccess = { viewModel.revokeAccess() }
            )
        },
        content = {padding ->
            ProfileContent(padding = padding)
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    )

    RevokeAccess(
        snackbarHostState = snackbarHostState,
        coroutineScope = coroutineScope,
        signOut = { viewModel.signOut() }
    )
}