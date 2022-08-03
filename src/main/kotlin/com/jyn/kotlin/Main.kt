// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.jyn.kotlin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    val items = listOf("TAB1", "TAB2", "TAB3")
    var selectedItem by remember { mutableStateOf(0) }


    MaterialTheme {
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            items.forEachIndexed { index, s ->
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable(
                            onClick = {
                                selectedItem = index
                            },
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(items[index])
                    Spacer(Modifier.padding(top = 2.dp))
                    AnimatedVisibility(visible = index == selectedItem) {
                        Surface(
                            shape = CircleShape,
                            modifier = Modifier.size(5.dp),
                            color = Color.Red
                        ) { }
                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) = application {
    Window(
        state = rememberWindowState().apply {
            size = DpSize(1000.dp, 600.dp)
            position = WindowPosition.Aligned(Alignment.Center)
        },
        onCloseRequest = ::exitApplication,
        title = "Hello Compose",
        resizable = false
    ) {
        App()
    }
}
