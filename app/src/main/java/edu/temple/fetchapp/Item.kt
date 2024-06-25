package edu.temple.fetchapp

import com.google.gson.annotations.SerializedName

//Data class to provide model for parsing JSON response into the data we want to use and sort, the
//list ID and name
data class Item(
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String
) {
    fun toModel() = Item(
        listId = this.listId,
        name = this.name
    )
}
