package com.example.myrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.data.Category
import com.example.myrecipes.data.DefaultImage
import com.example.myrecipes.R
import com.squareup.picasso.Picasso

class AdapterForCategories(
    private val list: Array<Category>,
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<AdapterForCategories.ViewHolder>() {

    interface RecyclerViewEvent {
        fun onItemClick(category: Category)
    }


    inner class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        val image: ImageView = view.findViewById(R.id.category_image)
        val title: TextView = view.findViewById(R.id.category_title)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val category = list[adapterPosition]
            listener.onItemClick(category)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        /*var image = ""

        if (item.image.isNotBlank()) {
            image = item.image
        } else {
            image =
        }*/


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
    }
}