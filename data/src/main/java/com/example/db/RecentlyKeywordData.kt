package com.example.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.MovieModel
import java.io.Serializable

@Entity(tableName = "recentlyKey")
data class RecentlyKeywordData(

    @PrimaryKey
    val keyWord: String
) : Serializable {

    companion object {
        const val RE_FRESH_TIME = 12
    }
}

//fun MovieModel.Items.toRoomObject(): RecentlyKeywordData
