package com.example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecentlyMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recentlyData: RecentlyMovieData)

    @Query("DELETE FROM recentlyMovie")
    fun clear()

    @Query("SELECT * FROM recentlyMovie LIMIT 10")
    fun selectAll(): List<RecentlyMovieData>
}