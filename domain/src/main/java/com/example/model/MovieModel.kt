package com.example.model

data class MovieModel(
    var items: ArrayList<Items>
) {
    data class Items(
        val title: String,
        val link: String,
        val image: String,
        val subtitle: String,
        val userRating: Double
    )
}