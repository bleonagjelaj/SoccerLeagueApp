package com.example.soccerleagueapp.domain.repositories

import com.example.soccerleagueapp.domain.models.GameModel
import com.example.soccerleagueapp.domain.models.TeamDetailsModel
import com.example.soccerleagueapp.domain.models.TeamModel
import com.example.soccerleagueapp.domain.models.TeamPreviewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class TeamsRepository {

    val teams = mutableListOf<TeamModel>()
    val games = mutableListOf<GameModel>()

    init {
        generateTeams()
    }

    private fun generateGames() {
        // Ensure there are an even number of teams
        if (teams.size % 2 != 0) {
            throw IllegalArgumentException("The number of teams must be even.")
        }

        val totalRounds = teams.size - 1
        val matchesPerRound = teams.size / 2

        for (round in 0 until totalRounds) {
            for (match in 0 until matchesPerRound) {
                val homeTeam = teams[match]
                val awayTeam = teams[teams.size - 1 - match]

                // Create a game pair for this match (home and away)
                val fixture = GameModel(
                    Pair(homeTeam.teamName, awayTeam.teamName),
                    Pair(Random.nextInt(0, 6), Random.nextInt(0,6)))

                // Store the game pair
                games.add(fixture)
            }

            // Rotate the teams for the next round
            val lastTeam = teams.last()
            teams.removeAt(teams.size - 1)
            teams.add(1, lastTeam)
        }
    }

    private fun generateTeams() {
        val teamNames = listOf(
            "Team A", "Team B", "Team C", "Team D", "Team E",
            "Team F", "Team G", "Team H", "Team I", "Team J",
            "Team K", "Team L", "Team M", "Team N", "Team O",
            "Team P", "Team Q", "Team R", "Team S", "Team T"
        )

        val cities = listOf(
            "City 1", "City 2", "City 3", "City 4", "City 5"
        )

        val coaches = listOf(
            "Coach 1", "Coach 2", "Coach 3", "Coach 4", "Coach 5"
        )

        // Generate 20 unique soccer teams
        for (i in 0 until 20) {
            val randomName = teamNames[i]
            val randomCity = cities[i % cities.size]
            val randomCoach = coaches[i % coaches.size]

            val team = TeamModel(
                teamId = i,
                teamName = randomName,
                cityName = randomCity,
                coachName = randomCoach,
                teamScore = 0
            )
            teams.add(team)
        }
    }

    fun getTeams(): Flow<List<TeamPreviewModel>> = flow {
        val teamsToPreview = mutableListOf<TeamPreviewModel>()
        teams.forEach { team ->
            teamsToPreview.add(
                TeamPreviewModel(
                    teamId = team.teamId,
                    teamName = team.teamName,
                    teamScore = team.teamScore
                )
            )
        }
        emit(teamsToPreview)
    }

    fun getTeamDetails(teamId: Int): Flow<TeamDetailsModel> {
        val team = teams.first { it.teamId == teamId }

        return flow {
            emit(
                TeamDetailsModel(
                    name = team.teamName,
                    coach = team.coachName,
                    city = team.cityName,
                    score = team.teamScore
                )
            )
        }
    }

    fun getGames(): Flow<List<GameModel>> = flow {
        generateGames()
        emit(games)
    }
}