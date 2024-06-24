package edu.temple.fetchapp

import retrofit2.Call
import retrofit2.http.GET

interface ItemAPI {
    @GET("hiring.json")
    fun getItems(): Call<List<Item>>
}