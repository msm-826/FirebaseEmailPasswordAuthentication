package com.project.emailpasswordauth.presentation.sign_in.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.emailpasswordauth.R
import com.project.emailpasswordauth.components.EmailField
import com.project.emailpasswordauth.components.PasswordField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInContent(
    padding: PaddingValues,
    signIn: (email: String, password: String) -> Unit,
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {

    val context = LocalContext.current

    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver, init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = context.getString(R.string.EMPTY_STRING)
                )
            )
        }
    )

    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver, init = {
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
                signIn(email.text, password.text)
            }
        ) {
            Text(
                text = stringResource(R.string.SIGN_IN_BUTTON),
                fontSize = 15.sp
            )
        }
        Row {
            Text(
                modifier = Modifier
                    .clickable {
                    navigateToForgotPasswordScreen()
                },
                text = stringResource(R.string.FORGOT_PASSWORD),
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                text = stringResource(R.string.VERTICAL_DIVIDER),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.clickable {
                    navigateToSignUpScreen()
                },
                text = stringResource(R.string.NO_ACCOUNT),
                fontSize = 15.sp
            )
        }
    }
}