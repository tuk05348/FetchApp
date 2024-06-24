package edu.temple.fetchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.TreeMap
import java.util.TreeSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = CoroutineScope(Job() + Dispatchers.Default)
        lateinit var itemList : List<Item>

        scope.launch {
            itemList = ItemListImpl().getItems().sortedBy { it.listId }
            Log.d("list", itemList.toString())
        }
    }
}