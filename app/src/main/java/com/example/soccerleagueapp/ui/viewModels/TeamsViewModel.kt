package com.example.soccerleagueapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerleagueapp.domain.models.TeamDetailsModel
import com.example.soccerleagueapp.domain.models.TeamModel
import com.example.soccerleagueapp.domain.models.TeamPreviewModel
import com.example.soccerleagueapp.domain.useCases.GetGamesListUseCase
import com.example.soccerleagueapp.domain.useCases.GetTeamDetailsUseCase
import com.example.soccerleagueapp.domain.useCases.GetTeamsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val getGamesListUseCase: GetGamesListUseCase,
    private val getTeamsListUseCase: GetTeamsListUseCase,
    private val getTeamDetailsUseCase: GetTeamDetailsUseCase
) : ViewModel() {

    private val _teamsList = MutableLiveData<List<TeamPreviewModel>>()
    val teamsList = _teamsList

    private val _teamDetails = MutableLiveData<TeamDetailsModel>()
    val teamDetails = _teamDetails


    fun getGames() {
        viewModelScope.launch {
            getGamesListUseCase().collect{ gamesListResponse ->

            }
        }
    }
    fun getTeams() {
        viewModelScope.launch {
            getTeamsListUseCase().collect { teamsListResponse ->
                _teamsList.value = teamsListResponse
            }
        }
    }

    fun getTeamDetails(teamId: Int) {
        viewModelScope.launch {
            getTeamDetailsUseCase(teamId).collect { teamDetailsResponse ->
                _teamDetails.value = teamDetailsResponse
            }
        }
    }
}