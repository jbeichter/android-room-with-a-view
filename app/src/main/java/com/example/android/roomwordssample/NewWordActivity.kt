/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Activity for entering a word.
 */

class NewWordActivity : ComponentActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewWordScreen(
                onClickSave = { word ->
                    val replyIntent = Intent()
                    if (word.isEmpty()) {
                        setResult(RESULT_CANCELED, replyIntent)
                    } else {
                        replyIntent.putExtra(EXTRA_REPLY, word)
                        setResult(RESULT_OK, replyIntent)
                    }
                    finish()
                }
            )
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}

@Composable
fun NewWordScreen(
    onClickSave: (String) -> Unit
) {
    var word by rememberSaveable { mutableStateOf("") }
    MyScaffold {
        Column {
            TextField(
                value = word,
                onValueChange = { word = it },
                label = { Text("Word…") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { onClickSave(word) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "SAVE"
                )
            }
        }
    }
}