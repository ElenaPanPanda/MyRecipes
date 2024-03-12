package com.example.myrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.ListRecipes
import com.example.myrecipes.R
import com.squareup.picasso.Picasso


class AdapterForCards(
    private val adapterList: ListRecipes
) : RecyclerView.Adapter<AdapterForCards.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val ingredientsRV: RecyclerView = view.findViewById(R.id.ingredients_recycle_view)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card, parent, false)
        )
    }

    override fun getItemCount(): Int = adapterList.listRecipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = adapterList.listRecipes[position]

        Picasso.get()
            .load(item.image)
            .into(holder.image)

        holder.title.text = item.title


        holder.ingredientsRV.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = AdapterForIngredients(item.ingredients)
        }

    }
}










