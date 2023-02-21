package com.example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecentlyKeywordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recentlyData: RecentlyKeywordData)

    @Query("DELETE FROM recentlyKey")
    fun clear()

    @Query("SELECT * FROM recentlyKey LIMIT 10")
    fun selectAll(): List<RecentlyKeywordData>
}