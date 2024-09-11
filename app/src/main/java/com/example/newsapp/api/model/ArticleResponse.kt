package com.example.newsapp.api.model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
) :BaseResponse()