package com.example.myrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.DefaultImage
import com.example.myrecipes.R
import com.example.myrecipes.Recipe
import com.squareup.picasso.Picasso

class AdapterForList(
    private val listRecipes: List<Recipe>,
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<AdapterForList.ViewHolder>() {

    interface RecyclerViewEvent {
        fun onItemClickForList(recipe: Recipe)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val image: ImageView = view.findViewById(R.id.image_in_list)
        val title: TextView = view.findViewById(R.id.title_in_list)
        val like: ImageView = view.findViewById(R.id.like_ic_in_list)

        init {
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val recipe = listRecipes[adapterPosition]
            listener.onItemClickForList(recipe)
        }
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

    override fun getItemCount(): Int = listRecipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = listRecipes[position]

        Picasso.get()
            .load(
                item.image.ifBlank {
                    DefaultImage.URL
                })
            .priority(Picasso.Priority.NORMAL)
            .placeholder(R.drawable.ic_black_image)
            .error(R.drawable.ic_black_image)
            .into(holder.image)

        holder.title.text = item.title

        if (item.favorite)
            holder.like.setBackgroundResource(R.drawable.ic_like)
        else
            holder.like.setBackgroundResource(R.drawable.ic_empty_like)
    }
}