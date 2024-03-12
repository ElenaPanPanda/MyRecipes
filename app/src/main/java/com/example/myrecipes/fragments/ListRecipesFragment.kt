package com.example.myrecipes.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.myrecipes.EXAMPLE_LIST
import com.example.myrecipes.R
import com.example.myrecipes.adapters.AdapterForCards
import com.example.myrecipes.databinding.FragmentListRecipesBinding


class ListRecipesFragment : Fragment(R.layout.fragment_list_recipes) {
    private lateinit var binding: FragmentListRecipesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListRecipesBinding.bind(view)

        binding.recycleView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterForCards(EXAMPLE_LIST)

            val helper = LinearSnapHelper()
            helper.attachToRecyclerView(this)
        }


    }
}