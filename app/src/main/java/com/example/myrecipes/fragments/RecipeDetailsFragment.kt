package com.example.myrecipes.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipes.R
import com.example.myrecipes.Recipe
import com.example.myrecipes.adapters.AdapterForIngredients
import com.example.myrecipes.api.ApiRest
import com.example.myrecipes.databinding.FragmentRecipeDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.runBlocking


class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {
    private lateinit var binding: FragmentRecipeDetailsBinding
    private var favorite = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailsBinding.bind(view)

        val theRecipe = arguments?.getParcelable<Recipe>(Recipe.KEY_ARG)!!


        Picasso.get()
            .load(theRecipe.image)
            .into(binding.imageInDetails)

        binding.titleInDetails.text = theRecipe.title

        favorite = theRecipe.favorite == true

        binding.likeBtnInDetails.setIconResource(
            if (favorite)
                R.drawable.ic_like
            else
                R.drawable.ic_empty_like
        )

        binding.likeBtnInDetails.setOnClickListener {
            changeLike(theRecipe)
        }

        binding.ingredientsRvInDetails.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterForIngredients(theRecipe.ingredients)
        }

        binding.instructions.text = theRecipe.instructions

        binding.deleteRecipeBtn.setOnClickListener {
            showDeleteDialog(theRecipe)
        }
    }

    private fun changeLike(theRecipe: Recipe) {
        favorite = if (favorite) {
            binding.likeBtnInDetails.setIconResource(R.drawable.ic_empty_like)
            false
        } else {
            binding.likeBtnInDetails.setIconResource(R.drawable.ic_like)
            true
        }

        changeLikeOnServer(theRecipe)
    }

    private fun changeLikeOnServer(theRecipe: Recipe) {
        theRecipe.favorite = favorite

        runBlocking {
            ApiRest.client.editRecipe(theRecipe.id, theRecipe)
        }
    }


    private fun showDeleteDialog(theRecipe: Recipe) {
    AlertDialog.Builder(requireContext())
        .setTitle(R.string.delete_this_recipe)
        .setPositiveButton(R.string.delete) { _, _ ->

            deleteRecipe(theRecipe)

            requireActivity().onBackPressedDispatcher.onBackPressed()

        }
        .setNegativeButton(R.string.cancel, null)
        .show()
}

    private fun deleteRecipe(theRecipe: Recipe) {
    runBlocking {
        ApiRest.client.deleteRecipe(theRecipe.id)
    }
}
}
