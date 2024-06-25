package edu.temple.fetchapp

//Interface for getting the list of items in a coroutine by using the suspend keyword
//thus we can asynchronously execute the API call
interface ItemList {
    suspend fun getItems(): List<Item>
}