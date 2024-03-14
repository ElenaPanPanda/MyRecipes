package com.example.myrecipes.fragments

import android.os.Bundle
import android.util.Log
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
        val bundle = Bundle()
        Log.d("asdf", Categories.LIST[position].toString())
        bundle.putParcelable(Categories.KEY_ARG, Categories.LIST[position])
        findNavController().navigate(R.id.listRecipesFragment, bundle)
    }
}