package com.example.soccerleagueapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soccerleagueapp.domain.models.GameModel
import com.example.soccerleagueapp.ui.theme.SoccerLeagueAppTheme

@Composable
fun GameTable(
    itemViewStates: List<GameModel>, onItemClicked: (Int) -> Unit = {}
) {
    val gradientColors = listOf(
        Color(0xFFB1C1C1), Color(0xFF4DFFFF), Color(0xFF00088E)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(gradientColors))
            .padding(10.dp)
    ) {
        Text(
            text = "Soccer League Teams",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
            items(itemViewStates) { data ->
                GameListItem(itemViewState = data, onItemClicked = onItemClicked)
                Divider(color = Color.Gray, thickness = 2.dp)
            }
        }
    }
}

@Composable
fun GameListItem(
    itemViewState: GameModel
) {
    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "${itemViewState.teamPair.first}   ${itemViewState.gameResult.first}:" +
                    "${itemViewState.gameResult.second}   ${itemViewState.teamPair.second}",
            fontSize = 18.sp,
            modifier = Modifier.padding(6.dp)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    SoccerLeagueAppTheme {
        GameTable(
            itemViewStates = listOf()
        )
    }
}