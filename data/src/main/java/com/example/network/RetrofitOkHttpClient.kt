package com.example.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.concurrent.TimeUnit

class RetrofitOkHttpClient {
    companion object {
        private const val TIMEOUT_READ: Long = 15L
        private const val TIMEOUT_CONNECT: Long = 15L
        private const val TIMEOUT_WRITE: Long = 15L

        fun getOkHttpClientBuilder(): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                .also { clientBuilder ->
                    clientBuilder.addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val original = chain.request();
                            val request = original.newBuilder()
                                .header("X-Naver-Client-Id", "L4ThFnsK2vHZ28_slR03")
                                .header(
                                    "X-Naver-Client-Secret",
                                    "DTsy7xXWn_"
                                )
                                .method(original.method, original.body)
                                .build();
                            return chain.proceed(request);
                        }
                    })
                }.build()
        }
    }
}
