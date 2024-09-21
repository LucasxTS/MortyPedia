package com.example.mortypedia.ui.components.characterComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mortypedia.R
import com.example.mortypedia.ui.features.character.CharacterViewModel

@Composable
fun NameSearchBarComponent(
    text: String,
    onTextChanged: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Text(
            text = stringResource(id = R.string.title_character_search),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            value = text,
            onValueChange = onTextChanged,
            label = { Text(text = stringResource(id = R.string.example_character_search)) },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true
        )
    }
}


@Preview
@Composable
fun NameSearchBarPreview() {

}