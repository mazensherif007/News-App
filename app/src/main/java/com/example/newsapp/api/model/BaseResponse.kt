package com.example.newsapp.api.model

import com.google.gson.annotations.SerializedName

open class BaseResponse (

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("code")
    val code: String? = null
)
