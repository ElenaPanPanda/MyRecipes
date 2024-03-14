package com.example.myrecipes.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.myrecipes.ApiRest
import com.example.myrecipes.Categories
import com.example.myrecipes.R
import com.example.myrecipes.Recipe
import com.example.myrecipes.adapters.AdapterForCards
import com.example.myrecipes.adapters.AdapterForList
import com.example.myrecipes.databinding.FragmentListRecipesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListRecipesFragment : Fragment(R.layout.fragment_list_recipes) {
    private lateinit var binding: FragmentListRecipesBinding
    private val snapHelper = LinearSnapHelper()
    private var cardsView = true
    private val scope = CoroutineScope(SupervisorJob())
    private val list = mutableListOf<Recipe>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListRecipesBinding.bind(view)

        setCardsView()


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


        val parcelableCategory = arguments?.getParcelable<Categories>(Categories.KEY_ARG)

        Log.d("asdf", parcelableCategory.toString())

        scope.launch {
            val response = ApiRest.client.getRecipesList(parcelableCategory)
            list.clear()
            list.addAll(response.listRecipes)
            withContext(Dispatchers.Main) {
                binding.recipesListRecycleView.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun setCardsView() {
        binding.recipesListRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterForCards(list)

            snapHelper.attachToRecyclerView(this)
        }
    }

    private fun setListView() {
        binding.recipesListRecycleView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterForList(list)

            snapHelper.attachToRecyclerView(null)
        }
    }
}