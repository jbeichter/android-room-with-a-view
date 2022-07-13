package com.example.android.roomwordssample

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyScaffold(
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("RoomWordsSample")
                }
            )
        },
        floatingActionButton = {
            floatingActionButton()
        },
        content = {
            Surface(
                modifier = Modifier.padding(16.dp)
            ) {
                content()
            }
        }
    )
}
