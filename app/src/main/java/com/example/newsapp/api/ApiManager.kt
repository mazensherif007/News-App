package com.example.newsapp.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object{

        const val BASE_URL = "https://newsapi.org"

        private var retrofit: Retrofit? = null

        private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor {
                Log.e("API_CALL", it) }
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            return logging
        }

        private fun provideHttpClient(): OkHttpClient{
            return OkHttpClient.Builder()
                .addInterceptor(provideLoggingInterceptor())
                .build()
        }

        private fun getInstance(): Retrofit{
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideHttpClient())
                    .build()
            }
            return retrofit!!
        }

        fun webService(): WebService {
            return getInstance().create(WebService::class.java)
        }
    }
}