package com.example.model.rp

import android.content.ClipData.Item
import com.example.model.MovieModel
import com.google.gson.annotations.SerializedName

data class RpMovieModel(
    @SerializedName("lastBuildDate")
    var lastBuildDate: String,
    @SerializedName("total")
    var total: Int,
    @SerializedName("start")
    var start: Int,
    @SerializedName("display")
    var display: Int,
    @SerializedName("items")
    var items: ArrayList<Items>
) {
    data class Items(
        @SerializedName("title")
        val title: String,
        @SerializedName("link")
        val link: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("subtitle")
        val subtitle: String,
        @SerializedName("pubdate")
        val pubDate: String,
        @SerializedName("director")
        val director: String,
        @SerializedName("actor")
        val actor: String,
        @SerializedName("userRating")
        val userRating: Double
    )

    fun mapper(): MovieModel {
        return MovieModel(
            items = ArrayList<MovieModel.Items>().apply {
                this@RpMovieModel.items.forEachIndexed { index, items ->
                    add(
                        MovieModel.Items(
                            title = items.title,
                            link = items.link,
                            image = items.image,
                            subtitle = items.subtitle,
                            userRating = items.userRating
                        )
                    )
                }
            }
        )
    }

}
