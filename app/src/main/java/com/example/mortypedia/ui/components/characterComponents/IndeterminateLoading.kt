package com.example.mortypedia.ui.components.characterComponents


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IndeterminateLoading() {

    Box(
        Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = Color.Blue,
            trackColor = Color.Gray,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }

}

@Preview
@Composable
fun IndeterminateLoadingPreview() {
    IndeterminateLoading()
}