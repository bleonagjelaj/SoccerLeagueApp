package com.example.soccerleagueapp.domain.models

data class GameModel (
    val teamPair: Pair<String, String>,
    val gameResult: Pair<Int, Int>
)