package com.example.soccerleagueapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soccerleagueapp.domain.models.TeamPreviewModel


@Composable
fun Teams(
    itemViewStates: List<TeamPreviewModel>,
    onItemClicked: (Int) -> Unit = {},
    onSeeGamesTableButtonClicked: () -> Unit
) {
    val gradientColors = listOf(
        Color(0xFFB1C1C1),
        Color(0xFF4DFFFF),
        Color(0xFF00088E)
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
        Button(onClick = onSeeGamesTableButtonClicked) {
            Text(text = "See game results")
        }
        LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
            items(itemViewStates) { data ->
                TeamListItem(itemViewState = data, onItemClicked = onItemClicked)
                Divider(color = Color.Gray, thickness = 2.dp)
            }
        }
    }
}

@Composable
fun TeamListItem(
    itemViewState: TeamPreviewModel,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(6.dp)
            .clickable { onItemClicked(itemViewState.teamId) }
    ) {
        Text(
            text = itemViewState.teamName,
            fontSize = 18.sp
        )
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Text(
            text = "Total Score: ${itemViewState.teamScore}",
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}