package com.example.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.MovieModel
import java.io.Serializable

@Entity(tableName = "recentlyMovie")
data class RecentlyMovieData(

    @PrimaryKey
    val title: String,
    val subtitle: String,
    val link: String?,
    val image: String?,
    val userRating: Double
) : Serializable {

    companion object {
        const val RE_FRESH_TIME = 12
    }
}

fun MovieModel.Items.toRoomObject(): RecentlyMovieData =
    RecentlyMovieData(
        title = title,
        image = image,
        subtitle = subtitle,
        link = link,
        userRating = userRating
    )
