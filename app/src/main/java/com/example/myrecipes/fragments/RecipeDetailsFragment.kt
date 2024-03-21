package com.example.myrecipes.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipes.R
import com.example.myrecipes.RECIPE_1
import com.example.myrecipes.adapters.AdapterForIngredients
import com.example.myrecipes.databinding.FragmentRecipeDetailsBinding
import com.squareup.picasso.Picasso


class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {
    private lateinit var binding: FragmentRecipeDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailsBinding.bind(view)

        //val parcelableRecipe = arguments?.getParcelable<Recipe>(Recipe.KEY_ARG)
        val recipe = RECIPE_1


        /*        val sideSheetDialog = SideSheetDialog(requireContext())
                sideSheetDialog.setContentView(R.layout.side_sheet)

               *//* binding.testButton.setOnClickListener {
            sideSheetDialog.show()
        }*/

        Picasso.get()
            .load(recipe.image)
            .into(binding.imageInDetails)

        binding.titleInDetails.text = recipe.title

        binding.ingredientsRvInDetails.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdapterForIngredients(recipe.ingredients)
        }

        binding.instructions.text = recipe.instructions
    }
}