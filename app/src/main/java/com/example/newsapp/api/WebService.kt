package com.example.newsapp.api

import com.example.newsapp.api.model.ArticleResponse
import com.example.newsapp.api.model.SourcesResponse
import com.example.newsapp.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("/v2/top-headlines/sources")
    suspend fun getSources(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("category") category: String
    ): SourcesResponse

    @GET("/v2/everything")
    suspend fun getArticles(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("sources") tabId: String,
    ): ArticleResponse
}