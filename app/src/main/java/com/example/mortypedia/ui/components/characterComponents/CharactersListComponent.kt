package com.example.mortypedia.ui.components.characterComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.example.mortypedia.R
import com.example.mortypedia.domain.models.CharactersModel
import com.example.mortypedia.domain.models.LocationName

@Composable
fun CharacterListComponent(charactersList: List<CharactersModel>) {
    LazyRow {
        items(charactersList) { item ->
            CharacterCardView(character = item)
        }
    }
}

@Composable
fun CharacterCardView(character: CharactersModel) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(250.dp)
            .height(340.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(colorResource(id = R.color.background_color_image))
        )
        Column(
            Modifier
                .fillMaxWidth()
                .offset(y = (-72).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

                Image(
                    painter = rememberAsyncImagePainter(character.image),
                    contentDescription = "Character Image",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(120.dp),
                    contentScale = ContentScale.Crop
                )

            Text(
                text = character.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.character_name),
                modifier = Modifier.padding(bottom = 6.dp, top = 8.dp)
            )

            Text(
                text = "Location: ${character.location.name}",
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp),
            )

            Divider(
                color = colorResource(id = R.color.green_divider_line),
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .width(80.dp)
            )

            Text(
                text = "Status: ${character.status}",
                fontSize = 12.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Button(
                modifier = Modifier
                    .height(4055.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = { },
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.portalgunrick),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = "Episodes",
                        color = colorResource(id = R.color.rick_episodes_green),
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun CharacterCardViewPreview() {
    CharacterCardView(CharactersModel(1, "Rick", "Alive", "Human", "sadsd", LocationName("dasdas"), "dfaksjdaklshd"))
}