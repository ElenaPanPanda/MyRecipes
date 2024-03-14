package com.example.myrecipes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myrecipes.Categories
import com.example.myrecipes.R
import com.example.myrecipes.adapters.AdapterForCategories
import com.example.myrecipes.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(R.layout.fragment_categories), AdapterForCategories.RecyclerViewEvent {
    private lateinit var binding: FragmentCategoriesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoriesBinding.bind(view)


        binding.categoriesRecycleView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = AdapterForCategories(Categories.LIST, this@CategoriesFragment)
        }

    }

    override fun onItemClick(position: Int) {
        /*val bundle = Bundle()
        bundle.putInt(WallpaperDetails.KEY_ARG_POSITION, position)
        findNavController().navigate(R.id.detailsFragment, bundle)*/
    }
}