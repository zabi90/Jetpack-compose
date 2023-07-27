package com.example.composejourney.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),

    ) {
        Text(text = text)
        Icon(
            Icons.Default.KeyboardArrowRight,
            contentDescription = ""
        )
    }
}


@Composable
@Preview(showBackground = true)
fun previewButton() {
    AppButton("Next"){}
}