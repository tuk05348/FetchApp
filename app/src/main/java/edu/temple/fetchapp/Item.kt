package edu.temple.fetchapp

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String
)
