package com.pepivsky.bottomnavigation.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pepivsky.bottomnavigation.R

class CollectionAdapter(val collections: List<Collection>): RecyclerView.Adapter<CollectionAdapter.CollectionHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CollectionHolder(layoutInflater.inflate(R.layout.item_collection_card, parent, false))
    }

    override fun onBindViewHolder(holder: CollectionHolder, position: Int) {
        holder.render(collections[position])
    }

    override fun getItemCount(): Int {
        return collections.size
    }

    class CollectionHolder(val view:View): RecyclerView.ViewHolder(view) {
        lateinit var tvTitle: TextView


        fun render(collection: Collection) {
            tvTitle = view.findViewById(R.id.tvTittle)


            tvTitle.text = collection.tittle

        }
    }
}