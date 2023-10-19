package com.example.soccerleagueapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.soccerleagueapp.domain.models.GameModel
import com.example.soccerleagueapp.domain.models.TeamDetailsModel
import com.example.soccerleagueapp.domain.models.TeamPreviewModel
import com.example.soccerleagueapp.ui.screens.GameTable
import com.example.soccerleagueapp.ui.screens.TeamDetails
import com.example.soccerleagueapp.ui.screens.TeamsList
import com.example.soccerleagueapp.ui.viewModels.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TeamsViewModel by viewModels()
    private val teamsListScreenKey = "teamsListScreen"
    private val teamDetailsScreenKey = "teamDetailsScreen"
    private val gameTableScreenKey = "gameTableScreen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var gamesList by remember { mutableStateOf(listOf<GameModel>()) }
            var teamsList by remember { mutableStateOf(listOf<TeamPreviewModel>()) }
            var teamDetails by remember {
                mutableStateOf(
                    TeamDetailsModel(
                        name = "",
                        coach = "",
                        city = "",
                        score = 0
                    )
                )
            }

            LaunchedEffect(true) {
                viewModel.getGames()
                viewModel.gamesList.observe(this@MainActivity) { games ->
                    gamesList = games
                }
                viewModel.teamsList.observe(this@MainActivity) { teams ->
                    teamsList = teams
                }
                viewModel.teamDetails.observe(this@MainActivity) { details ->
                    teamDetails = details
                }
            }

            NavHost(navController = navController, startDestination = gameTableScreenKey) {
                composable(gameTableScreenKey) {
                    GameTable(itemViewStates = gamesList)
                }
                composable(teamsListScreenKey) {
                    TeamsList(
                        itemViewStates = teamsList,
                        onItemClicked = { teamId ->
                            viewModel.getTeamDetails(teamId)
                            navController.navigate(teamDetailsScreenKey)
                        })
                }
                composable(teamDetailsScreenKey) {
                    TeamDetails(teamDetails)
                }
            }
        }
    }
}