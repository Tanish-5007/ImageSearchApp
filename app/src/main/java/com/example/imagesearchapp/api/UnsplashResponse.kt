package com.example.imagesearchapp.api


import com.example.imagesearchapp.data.model.UnsplashPhoto
import com.google.gson.annotations.SerializedName

data class UnsplashResponse(
    @SerializedName("results")
    val results: List<UnsplashPhoto>,
//    @SerializedName("total")
//    val total: Int,
//    @SerializedName("total_pages")
//    val totalPages: Int
)