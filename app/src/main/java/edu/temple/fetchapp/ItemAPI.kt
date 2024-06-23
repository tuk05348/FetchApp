package edu.temple.fetchapp

import retrofit2.Call
import retrofit2.http.GET
import java.util.TreeMap
import java.util.TreeSet

interface ItemAPI {
    @GET("hiring.json")
    fun getItems(): Call<List<Item>>
}