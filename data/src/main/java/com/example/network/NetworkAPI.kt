package com.example.network

import com.example.model.rp.RpMovieModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {
    /**
     * 버전 체크
     */
    @GET("search/movie.json")
    fun getVersion(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Single<RpMovieModel>
}
