package com.example.composejourney.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composejourney.ui.theme.Pink
import com.example.composejourney.ui.theme.Pink_100


@Composable
fun MenuSwitch(
    items: List<MenuSwitchItem>,
    onItemClicked: (item: MenuSwitchItem) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(items.first()) }
    Row(
        modifier = modifier.background(
            color = Pink_100,
            shape = RoundedCornerShape(32.dp)
        ),
        horizontalArrangement = Arrangement.Center
    ) {
        Log.d("SwitchItems in row", items.toString())
        for (item in items) {
            MenuItem(item, item == selectedItem, Modifier
                .padding(8.dp)
                .weight(1f), onClick = {
                selectedItem = item
            })
        }
    }
}


@Composable
fun MenuItem(
    selectedItem: MenuSwitchItem,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = if (isSelected) Pink else Color.Transparent),
        modifier = modifier
    ) {
        Text(text = selectedItem.title, color = if (isSelected) Color.White else Pink)
    }
}

data class MenuSwitchItem(val title: String, var isSelected: Boolean = false)


@Preview(showBackground = true)
@Composable
fun MenuSwitchPreview(modifier: Modifier = Modifier) {
    MenuSwitch(
        listOf<MenuSwitchItem>(
            MenuSwitchItem("Login", true),
            MenuSwitchItem("Sign Up", false)
        ), {}, modifier.fillMaxWidth()
    )
}