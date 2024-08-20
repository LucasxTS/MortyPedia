package com.example.mortypedia.ui.components.characterComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mortypedia.R

@Composable
fun ToggleStatusComponent(
    selectedOption: Int,
    onOptionSelected: (Int) -> Unit
) {
    val options = listOf(
        Pair(R.drawable.skull, "Dead"),
        Pair(R.drawable.alivepng, "Alive"),
        Pair(R.drawable.unknown, "Unknown")
    )

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Status",
                color = colorResource(id = R.color.character_logo)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            options.forEachIndexed { index, imageRes ->
                val isSelected = selectedOption == index
                val color = if (isSelected) colorResource(id = R.color.character_logo)
                else colorResource(id = R.color.black)
                TextButton(
                    onClick = { onOptionSelected(index) },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = imageRes.first),
                            contentDescription = "Option ${index + 1}",
                            modifier = Modifier
                                .size(64.dp),
                            contentScale = ContentScale.Fit,
                            colorFilter = ColorFilter.tint(color)
                        )
                        Text(
                            text = imageRes.second,
                            color = color
                        )
                    }


                }
            }
        }
    }

}

@Preview
@Composable
fun ToggleStatusComponentPreview() {
    ToggleStatusComponent(1, {})
}