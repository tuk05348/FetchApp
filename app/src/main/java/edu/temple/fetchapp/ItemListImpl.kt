package edu.temple.fetchapp

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class ItemListImpl: ItemList {

    private val baseUrl = "https://fetch-hiring.s3.amazonaws.com/"

    private val itemAPI: ItemAPI

    init {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()

        itemAPI = retrofit.create(ItemAPI::class.java)
    }

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