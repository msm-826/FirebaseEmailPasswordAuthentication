package com.project.emailpasswordauth.presentation.profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileContent(
    padding: PaddingValues
) {

    Box(
        modifier = Modifier.fillMaxSize().padding(padding).padding(top = 48.dp)
    ) {
        Text(
            text = "Welcome",
            fontSize = 24.sp
        )
    }
}