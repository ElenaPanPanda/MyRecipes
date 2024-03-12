package com.example.myrecipes.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.myrecipes.EXAMPLE_LIST
import com.example.myrecipes.R
import com.example.myrecipes.adapters.AdapterForCards
import com.example.myrecipes.adapters.AdapterForList
import com.example.myrecipes.databinding.FragmentListRecipesBinding


class ListRecipesFragment : Fragment(R.layout.fragment_list_recipes) {
    private lateinit var binding: FragmentListRecipesBinding
    private val snapHelper = LinearSnapHelper()
    private var cardsView = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListRecipesBinding.bind(view)


        setCardsView()

        binding.topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_icon -> {
                    // Handle edit text press
                    true
                }
                R.id.change_view_icon -> {


                    cardsView = if (cardsView) {
                        setListView()
                        menuItem.setIcon(R.drawable.ic_list)
                        false
                    } else {
                        setCardsView()
                        menuItem.setIcon(R.drawable.ic_carousel)
                        true
                    }

                    true
                }
                else -> false
            }
        }





    }

    private fun setCardsView() {
        binding.recycleView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterForCards(EXAMPLE_LIST)

            snapHelper.attachToRecyclerView(this)
        }
    }

    private fun setListView() {
        binding.recycleView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterForList(EXAMPLE_LIST)

            snapHelper.attachToRecyclerView(null)
        }
    }
}