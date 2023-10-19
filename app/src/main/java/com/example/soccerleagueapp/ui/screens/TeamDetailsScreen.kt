package com.example.soccerleagueapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soccerleagueapp.domain.models.TeamDetailsModel

@Composable
fun TeamDetails(
    teamDetailsModel: TeamDetailsModel
) {
    val gradientColors = listOf(
        Color(0xFFB1C1C1),
        Color(0xFF4DFFFF),
        Color(0xFF00088E)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(gradientColors))
    ) {
        Text(
            text = teamDetailsModel.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = "City: ${teamDetailsModel.city}",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = "Coach: ${teamDetailsModel.coach}",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = "Score: ${teamDetailsModel.score}",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}
