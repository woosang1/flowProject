package com.example.network

import com.example.model.rp.RpMovieModel
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Provider

class NetworkManager @Inject constructor(
    private val retrofitClient: Provider<RetrofitClient>
) {

    fun getMovieData(
        query: String,
        display: Int
    ): Single<RpMovieModel> = retrofitClient.get().getVersionRetrofit(NetworkAPI::class.java).getVersion(
        query = query, display = display
    )
}

