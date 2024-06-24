package edu.temple.fetchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemMapDisplayAdapter (_itemMap : Map<Int, List<String>>) : RecyclerView.Adapter<ItemMapDisplayAdapter.ItemMapViewHolder>() {

    private val itemMap = _itemMap
    inner class ItemMapViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        val listIdTextView = layout.findViewById<TextView>(R.id.listIdTextView)
        val nameListTextView = layout.findViewById<TextView>(R.id.nameListTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMapViewHolder {
        return ItemMapViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_itemmap, parent, false)
        )
    }

    override fun getItemCount() = itemMap.size

    override fun onBindViewHolder(holder: ItemMapViewHolder, position: Int) {
        val key = itemMap.keys.elementAt(position)
        holder.listIdTextView.text = key.toString()
        holder.nameListTextView.text = itemMap[key].toString()
    }
}