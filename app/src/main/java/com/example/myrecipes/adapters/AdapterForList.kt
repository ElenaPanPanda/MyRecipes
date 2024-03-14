package com.example.myrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.R
import com.example.myrecipes.Recipe
import com.squareup.picasso.Picasso

class AdapterForList(
    private val adapterList: List<Recipe>
) : RecyclerView.Adapter<AdapterForList.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_in_list)
        val title: TextView = view.findViewById(R.id.title_in_list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_for_list, parent, false)
        )
    }

    override fun getItemCount(): Int = adapterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = adapterList[position]

        Picasso.get()
            .load(item.image)
            .into(holder.image)

        holder.title.text = item.title
    }
}