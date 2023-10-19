package com.example.soccerleagueapp.domain

import com.example.soccerleagueapp.domain.models.GameModel
import com.example.soccerleagueapp.domain.models.TeamDetailsModel
import com.example.soccerleagueapp.domain.models.TeamModel
import com.example.soccerleagueapp.domain.models.TeamPreviewModel
import kotlinx.coroutines.flow.Flow

interface UseCases {
    interface GetTeamsList {
        suspend fun invoke(): Flow<List<TeamPreviewModel>>
    }

    interface GetTeamDetails {
        suspend fun invoke(teamId: Int): Flow<TeamDetailsModel>
    }

    interface GetGamesList {
        suspend fun invoke(): Flow<List<GameModel>>
    }
}