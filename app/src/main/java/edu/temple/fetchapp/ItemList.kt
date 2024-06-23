package edu.temple.fetchapp

import java.util.TreeMap
import java.util.TreeSet

interface ItemList {
    suspend fun getItems(): List<Item>
}