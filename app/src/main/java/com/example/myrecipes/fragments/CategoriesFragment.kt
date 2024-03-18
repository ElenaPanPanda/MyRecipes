package com.example.myrecipes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myrecipes.Category
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
            adapter = AdapterForCategories(Category.LIST, this@CategoriesFragment)
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.add_icon -> {
                    AddRecipeDialogFragment().show(childFragmentManager, AddRecipeDialogFragment.TAG)

                    true
                }

                R.id.search_icon -> {
                    // Handle edit text press
                    true
                }

                else -> false
            }
        }
    }

    override fun onItemClick(category: Category) {
        val bundle = Bundle()
        bundle.putParcelable(Category.KEY_ARG, category)
        findNavController().navigate(R.id.listRecipesFragment, bundle)
    }
}