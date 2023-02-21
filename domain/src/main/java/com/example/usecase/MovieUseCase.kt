package com.example.usecase

import com.example.model.MovieModel
import com.example.repository.MovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    fun getMovie(
        query: String, display: Int, success: (MovieModel) -> Unit, fail: (String) -> Unit
    ) {
        repository.getMovie(
            query = query,
            display = display,
            success = success,
            fail = fail
        )
    }
}