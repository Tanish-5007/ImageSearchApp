package com.example.imagesearchapp.data.model


import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("name")
    val name: String,

    @SerializedName("username")
    val username: String

){
    val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"
}