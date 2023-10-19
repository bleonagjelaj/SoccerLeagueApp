package com.example.soccerleagueapp.di

import com.example.soccerleagueapp.domain.repositories.TeamsRepository
import com.example.soccerleagueapp.domain.useCases.GetGamesListUseCase
import com.example.soccerleagueapp.domain.useCases.GetTeamDetailsUseCase
import com.example.soccerleagueapp.domain.useCases.GetTeamsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SoccerLeagueAppModule {

    @Provides
    @Singleton
    fun provideTeamsRepository(): TeamsRepository {
        return TeamsRepository()
    }

    @Provides
    @Singleton
    fun provideGetTeamsListUseCase(teamsRepository: TeamsRepository): GetTeamsListUseCase {
        return GetTeamsListUseCase(teamsRepository)
    }

    @Provides
    @Singleton
    fun provideGetTeamDetailsUseCase(teamsRepository: TeamsRepository): GetTeamDetailsUseCase {
        return GetTeamDetailsUseCase(teamsRepository)
    }

    @Provides
    @Singleton
    fun provideGetGamesListUseCase(teamsRepository: TeamsRepository): GetGamesListUseCase {
        return GetGamesListUseCase(teamsRepository)
    }
}