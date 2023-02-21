package com.example.di

import com.example.network.NetworkManager
import com.example.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(
        networkManager: NetworkManager,
    ) : RetrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun provideNetworkManager(retrofitClient : Provider<RetrofitClient>) : NetworkManager = NetworkManager(retrofitClient)

}