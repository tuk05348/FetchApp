package edu.temple.fetchapp

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class ItemListImpl: ItemList {

    private val baseUrl = "https://fetch-hiring.s3.amazonaws.com/" //API endpoint

    private val itemAPI: ItemAPI //Instance for making API call

    init {
        //Logging interceptor to log response and request and check we are indeed getting data
        //for debugging purposes
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        //HTTP client for making request
        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        //Retrofit instance that deserializes the requested data and handles the API call
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()

        itemAPI = retrofit.create(ItemAPI::class.java)
    }

    //method makes API call and checks if the response was successful, if so it takes the list
    //of items, filters out all null or empty names, and maps each to the Item model data class
    override suspend fun getItems(): List<Item> {
        return try {
            val response = itemAPI.getItems().awaitResponse()
            if (response.isSuccessful) {
                val items = response.body() ?: emptyList()
                items
                    .filter { !it.name.isNullOrEmpty() }
                    .map { it.toModel() }
            } else {
                emptyList()
            }
        } catch (exception: Exception) {
            Log.d("E", exception.toString())
            emptyList()
        }
    }
}