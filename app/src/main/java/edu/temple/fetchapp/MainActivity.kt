package edu.temple.fetchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val scope = CoroutineScope(Job() + Dispatchers.Default)

        scope.launch {
            val itemMap: Map<Int, List<String>> = ItemListImpl()
                .getItems().sortedWith(compareBy({it.listId}, { it.name.filter { name -> name.isDigit() }.toInt() }))
                .groupBy ({it.listId}, {it.name} )
            withContext(Dispatchers.Main) {
                recyclerView.adapter = ItemMapDisplayAdapter(itemMap)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}