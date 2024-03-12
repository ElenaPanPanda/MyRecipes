package com.example.myrecipes.fragments


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.myrecipes.EXAMPLE_LIST
import com.example.myrecipes.ListRecipes
import com.example.myrecipes.R
import com.example.myrecipes.Recipe
import com.example.myrecipes.adapters.AdapterForCards
import com.example.myrecipes.adapters.AdapterForList
import com.example.myrecipes.databinding.FragmentListRecipesBinding


class ListRecipesFragment : Fragment(R.layout.fragment_list_recipes) {
    private lateinit var binding: FragmentListRecipesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListRecipesBinding.bind(view)


        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_icon -> {
                    // Handle edit text press
                    true
                }
                R.id.view_icon -> {
                    // Handle favorite icon press
                    true
                }
                else -> false
            }
        }

        binding.recycleView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterForCards(EXAMPLE_LIST)

            val helper = LinearSnapHelper()
            helper.attachToRecyclerView(this)
        }

        /*binding.recycleView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterForList(EXAMPLE_LIST)
        }*/

    }
}