package com.example.imagesearchapp.data.model


import com.google.gson.annotations.SerializedName

data class UnsplashPhoto(

    @SerializedName("description")
    val description: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("urls")
    val urls: Urls,

    @SerializedName("user")
    val user: User,

    )