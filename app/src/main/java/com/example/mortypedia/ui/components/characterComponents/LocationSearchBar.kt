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
fun LocationSearchBarComponent(viewModel: CharacterViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Text(
            text = stringResource(id = R.string.title_location_search),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(4.dp))
        TextField(
            value = viewModel.locationQuery,
            onValueChange = {
                viewModel.locationQuery = it
                viewModel.applyFilters()
                            },
            label = { Text(text = stringResource(id = R.string.example_location_search)) },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true
        )
    }
}

@Preview
@Composable
fun LocationSearchBarComponentPreview() {

}