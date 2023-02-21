package com.example.repository

import com.example.model.MovieModel

interface MovieRepository {
    fun getMovie(query: String, display: Int, success: (MovieModel) -> Unit, fail: (String) -> Unit)
}