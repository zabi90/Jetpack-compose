package com.example.composejourney.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composejourney.R
import com.example.composejourney.screens.LoginScreen

@Composable
fun RoundedButton (modifier : Modifier = Modifier) {
    Box( modifier = modifier, contentAlignment = Alignment.Center) {
        Image(painter = painterResource(R.drawable.face_book), modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(4.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(25.dp)),
            contentDescription = "rounded_button_icon")
    }
}

@Preview(showBackground = true)
@Composable
fun loginPreview() {
    RoundedButton()
}