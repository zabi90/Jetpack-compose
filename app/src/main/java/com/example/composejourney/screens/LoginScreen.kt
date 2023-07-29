package com.example.composejourney.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composejourney.composables.MenuSwitch
import com.example.composejourney.composables.MenuSwitchItem
import com.example.composejourney.ui.theme.Dark_100
import com.example.composejourney.ui.theme.Light_80
import com.example.composejourney.ui.theme.Dark_80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }


    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.headlineLarge,
            color = Dark_100,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
        Text(
            text = "Sign up or login to your Account.",
            style = MaterialTheme.typography.bodyLarge,
            color = Dark_80,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        MenuSwitch(
            listOf(
                MenuSwitchItem("Login", true),
                MenuSwitchItem("Sign Up", false)
            ),{

            }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(
            text = "Email Address",
            style = MaterialTheme.typography.titleMedium,
            color = Dark_100,
            modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        )

        TextField(
            value = email.value,
            placeholder = { Text(text = "Enter your Email") },
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Light_80,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            )
        )
        Text(
            text = "Password",
            style = MaterialTheme.typography.titleMedium,
            color = Dark_100,
            modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        )
        TextField(
            value = password.value,
            placeholder = { Text(text = "Enter your Password") },
            onValueChange = {
                password.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Light_80,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun loginPreview() {
    LoginScreen()
}