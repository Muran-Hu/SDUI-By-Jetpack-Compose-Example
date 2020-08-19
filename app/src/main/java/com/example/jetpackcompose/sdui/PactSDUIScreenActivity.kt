package com.example.jetpackcompose.sdui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class PactSDUIScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomScreen()
        }
    }
}

@Composable
fun CustomScreen() {
    Column {
        H1(displayText = "H1 - Hello, Pact SDUI Demo")
        H2(displayText = "H2 - Hello, Pact SDUI Demo")
        H3(displayText = "H3 - Hello, Pact SDUI Demo")
    }
}

@Preview
@Composable
fun CustomScreenPreview() {
    CustomScreen()
}