package com.example.di

import com.example.repository.MovieRepositoryImp
import com.example.usecase.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author 이우상
 * Created 2023/02/13 at 09:40 AM
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideMovieUseCase(repository: MovieRepositoryImp) = MovieUseCase(repository)

}
