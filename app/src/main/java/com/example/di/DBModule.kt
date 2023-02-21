package com.example.di

import android.content.Context
import com.example.db.DataBase
import com.example.db.RecentlyKeywordDao
import com.example.db.RecentlyMovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    /**
     *  recentlyMovieDao : 최근 본 영화
     */
    @Provides
    fun provideRecentlyMovieDao(@ApplicationContext context: Context): RecentlyMovieDao {
        return DataBase.getInstance(context).recentlyMovieDao()
    }

    @Provides
    fun provideRecentlyKeyDao(@ApplicationContext context: Context): RecentlyKeywordDao {
        return DataBase.getInstance(context).recentlyKeywordDao()
    }

}