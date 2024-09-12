package com.example.superheroes


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        HeroApp()
            }
        }
    }
}

@Composable
fun HeroApp() {
    Scaffold (topBar={ HeroTopAppBar()}
    ){ it ->

        LazyColumn(contentPadding = it) {
            items(heroes) {
                HeroesListItem(
                    hero = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun HeroesListItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .height(IntrinsicSize.Min)
        ) {
            Column (modifier = Modifier.weight(0.6f).padding(8.dp)){
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 4.dp)
//                    maxLines = 2, // Set the maximum number of lines
//                    overflow = TextOverflow.Ellipsis // Truncate the text with an ellipsis
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(8.dp)
                    .aspectRatio(1f)
                    .size(100.dp)
                    .clip(MaterialTheme.shapes.small)
            ) {
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        modifier = modifier
            .padding(vertical = 14.dp)
            .padding(bottom = 4.dp),
        title = {
                Text(text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge)
        }
    )
}

@Preview
@Composable
fun HeroPreview(){
    SuperheroesTheme {
        HeroApp()
    }}

@Preview
@Composable
fun BusDarkThemePreview(){
    SuperheroesTheme(darkTheme = true){
        HeroApp()
    }
}}

