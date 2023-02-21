package com.example.di

import com.example.network.NetworkManager
import com.example.repository.MovieRepository
import com.example.repository.MovieRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSplashRepository(networkManager: NetworkManager) : MovieRepository = MovieRepositoryImp(networkManager)


}