package com.example.soccerleagueapp.domain.models

data class TeamModel(
    val teamId: Int,
    val teamName: String,
    val cityName: String,
    val coachName: String,
    var teamScore: Int
)