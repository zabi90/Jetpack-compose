package com.example.composejourney.extension

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.textFieldModifier(isFocused: Boolean) : Modifier {

    return this
        .border(
            width = 1.dp,
            color = if (isFocused) Color.Black else Color.Transparent,
            shape = RoundedCornerShape(16.dp)
        )
}