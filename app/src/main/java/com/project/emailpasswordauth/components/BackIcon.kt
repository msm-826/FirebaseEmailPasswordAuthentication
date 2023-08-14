package com.project.emailpasswordauth.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun BackIcon(
    navigateBack: () -> Unit
) {
    IconButton(
        onClick = navigateBack
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
        )
    }
}