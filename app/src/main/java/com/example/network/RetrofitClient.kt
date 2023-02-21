package com.example.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        const val baseUrl = "https://openapi.naver.com/v1/"
    }

    fun <S> getVersionRetrofit(service: Class<S>): S =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                RetrofitOkHttpClient.getOkHttpClientBuilder()
            )
            .baseUrl(baseUrl)
            .build()
            .create(service)
}