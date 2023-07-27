package com.example.composejourney.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composejourney.R
import com.example.composejourney.ui.theme.Dark_100
import com.example.composejourney.ui.theme.Dark_80

@Composable
fun onBoarding(title: String, body: String, modifier: Modifier = Modifier) {
    Column (modifier){
        Image(
            painter = painterResource(id = R.drawable.rectangle_on_boarding),
            contentDescription = "",
            modifier = Modifier.padding(16.dp).weight(1f).fillMaxWidth(),
        )
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            style = MaterialTheme.typography.headlineLarge,
            color = Dark_100,

        )
        Text(
            text = body,
            modifier = Modifier.padding(8.dp),
            color = Dark_80,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
    onBoarding(
        "Wide range of Food Categories & more",
        "Browse through our extensive list of restaurants and dishes, and when you're ready to order, simply add your desired items to your cart and checkout. It's that easy!"
    )
}