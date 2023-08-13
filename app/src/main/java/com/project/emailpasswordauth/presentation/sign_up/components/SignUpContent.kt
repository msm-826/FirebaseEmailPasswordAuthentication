package com.project.emailpasswordauth.presentation.sign_up.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.emailpasswordauth.R
import com.project.emailpasswordauth.components.EmailField
import com.project.emailpasswordauth.components.PasswordField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpContent(
    padding: PaddingValues,
    signUp: (email: String, password: String) -> Unit,
    navigateBack: () -> Unit
) {

    val context = LocalContext.current

    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = context.getString(R.string.EMPTY_STRING)
                )
            )
        }
    )
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = context.getString(R.string.EMPTY_STRING)
                )
            )
        }
    )
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailField(
            email = email,
            onEmailValueChange = { newValue ->
                email = newValue
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        PasswordField(
            password = password,
            onPasswordValueChange = { newValue ->
                password = newValue
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                keyboard?.hide()
                signUp(email.text, password.text)
            }
        ) {
            Text(
                text = stringResource(R.string.SIGN_UP_BUTTON),
                fontSize = 15.sp
            )
        }
        Text(
            modifier = Modifier.clickable {
                navigateBack()
            },
            text = stringResource(R.string.ALREADY_USER),
            fontSize = 15.sp
        )
    }
}