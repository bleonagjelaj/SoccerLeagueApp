package com.example.soccerleagueapp.domain.useCases

import com.example.soccerleagueapp.domain.UseCases
import com.example.soccerleagueapp.domain.models.GameModel
import com.example.soccerleagueapp.domain.repositories.TeamsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGamesListUseCase @Inject constructor(
    private val teamsRepository: TeamsRepository
): UseCases.GetGamesList {
    override suspend operator fun invoke(): Flow<List<GameModel>> {
        return teamsRepository.getGames()
    }
}