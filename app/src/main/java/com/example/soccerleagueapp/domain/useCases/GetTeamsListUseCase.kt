package com.example.soccerleagueapp.domain.useCases

import com.example.soccerleagueapp.domain.UseCases
import com.example.soccerleagueapp.domain.models.TeamPreviewModel
import com.example.soccerleagueapp.domain.repositories.TeamsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamsListUseCase @Inject constructor(
    private val teamsRepository: TeamsRepository
): UseCases.GetTeamsList {
    override suspend operator fun invoke(): Flow<List<TeamPreviewModel>> {
        return teamsRepository.getTeams()
    }
}