package com.example.soccerleagueapp.domain.useCases

import com.example.soccerleagueapp.domain.UseCases
import com.example.soccerleagueapp.domain.models.TeamDetailsModel
import com.example.soccerleagueapp.domain.repositories.TeamsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamDetailsUseCase @Inject constructor(
    private val teamsRepository: TeamsRepository
): UseCases.GetTeamDetails {
    override suspend operator fun invoke(teamId: Int): Flow<TeamDetailsModel> {
        return teamsRepository.getTeamDetails(teamId)
    }
}