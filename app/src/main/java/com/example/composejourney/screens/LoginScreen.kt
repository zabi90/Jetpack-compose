package com.example.composejourney.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composejourney.AppNavigator
import com.example.composejourney.R
import com.example.composejourney.composables.AppButton
import com.example.composejourney.extension.textFieldModifier
import com.example.composejourney.ui.theme.Dark_100
import com.example.composejourney.ui.theme.Dark_80
import com.example.composejourney.ui.theme.Light_80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    var isFocusedEmail by remember { mutableStateOf(false) }
    var isFocusedPassword by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {

        Text(
            text = stringResource(R.string.email_address),
            style = MaterialTheme.typography.titleMedium,
            color = Dark_100,
            modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        )

        TextField(
            value = email.value,
            placeholder = { Text(text = stringResource(R.string.enter_your_email)) },
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .textFieldModifier(isFocusedEmail)
                .onFocusChanged { focusState ->
                    isFocusedEmail = focusState.isFocused
                },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Light_80,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Text(
            text = stringResource(R.string.password),
            style = MaterialTheme.typography.titleMedium,
            color = Dark_100,
            modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        )
        TextField(
            value = password.value,
            placeholder = { Text(text = stringResource(R.string.enter_your_password)) },
            onValueChange = {
                password.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .textFieldModifier(isFocusedPassword)
                .onFocusChanged { focusState ->
                    isFocusedPassword = focusState.isFocused
                },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Light_80,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
        )

        Text(
            text = stringResource(R.string.forgot_password), modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
                .clickable {

                },
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.titleMedium,
            color = Dark_80
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.or_login_using),
                style = MaterialTheme.typography.titleMedium,
                color = Dark_80
            )
            Divider(thickness = 1.dp, color = Dark_80, modifier = Modifier.padding(start = 8.dp))
        }
        Spacer(modifier = Modifier.weight(1f))
        AppButton(
            text = stringResource(R.string.login), modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            hideIcon = false

        ) {
            navController.navigate(AppNavigator.Routes.MAIN)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun loginPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}