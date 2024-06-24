package edu.temple.fetchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemListDisplayAdapter(_itemList: List<String>) : RecyclerView.Adapter<ItemListDisplayAdapter.ItemListViewHolder>() {

        private val itemList = _itemList
        inner class ItemListViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
            val itemTextView: TextView = layout.findViewById<TextView>(R.id.itemTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
            return ItemListViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_itemlist, parent, false)
                )
        }

        override fun getItemCount() = itemList.size

        override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
            holder.itemTextView.text = itemList[position]
        }

}