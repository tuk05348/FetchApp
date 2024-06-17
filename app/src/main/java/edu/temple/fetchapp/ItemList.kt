package edu.temple.fetchapp

interface ItemList {
    suspend fun getItems(): List<Item>
}