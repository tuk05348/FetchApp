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

        scope.launch {
            val itemList = ItemListImpl().getItems().sortedWith(compareBy({it.listId}, {it.name}))
            Log.d("list", itemList.toString())
        }
    }
}