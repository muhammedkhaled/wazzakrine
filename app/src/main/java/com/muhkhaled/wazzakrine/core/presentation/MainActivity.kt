package com.muhkhaled.wazzakrine.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muhkhaled.wazzakrine.core.presentation.components.BackDrop
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WazzakrineTheme {
                BackDrop(true)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WazzakrineTheme {
    }
}