package edu.temple.fetchapp

import retrofit2.Call
import retrofit2.http.GET

//Interface for defining the API request, we make a GET request for hiring.json to get a list of items
interface ItemAPI {
    @GET("hiring.json")
    fun getItems(): Call<List<Item>>
}