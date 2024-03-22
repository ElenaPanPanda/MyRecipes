package com.example.myrecipes.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.CheckBox
import com.example.myrecipes.Category
import com.example.myrecipes.R
import com.example.myrecipes.Recipe
import com.example.myrecipes.api.ApiRest
import com.example.myrecipes.databinding.CategoryCheckBoxBinding
import com.example.myrecipes.databinding.FragmentAddRecipeBinding
import com.example.myrecipes.databinding.IngredientAddLayoutBinding
import kotlinx.coroutines.runBlocking


class AddRecipeFragment : Fragment(R.layout.fragment_add_recipe) {
    private lateinit var binding: FragmentAddRecipeBinding
    private val checkBoxList = mutableListOf<CheckBox>()
    private var favorite = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddRecipeBinding.bind(view)

        addIngredientField()
        addIngredientField()

        addCategoriesCheckBoxes()

        binding.addIngredientBtn.setOnClickListener {
            addIngredientField()
        }

        binding.openCategoriesBtn.setOnClickListener {
            when (binding.categoriesCheckboxContainer.visibility) {
                View.VISIBLE -> {
                    binding.categoriesCheckboxContainer.visibility = View.GONE
                    binding.openCategoriesBtn.setIconResource(R.drawable.ic_right)
                }

                View.GONE -> {
                    binding.categoriesCheckboxContainer.visibility = View.VISIBLE
                    binding.openCategoriesBtn.setIconResource(R.drawable.ic_up)

                }

                else -> {}
            }
        }

        binding.likeBtnInAddRecipe.setOnClickListener {
            favorite = if (favorite) {
                binding.likeBtnInAddRecipe.setIconResource(R.drawable.ic_empty_like)
                false
            } else {
                binding.likeBtnInAddRecipe.setIconResource(R.drawable.ic_like)
                true
            }
        }

        binding.saveBtn.setOnClickListener {
            showSaveRecipeDialog()
        }
    }

    private fun addIngredientField() {
        val view = IngredientAddLayoutBinding.inflate(layoutInflater)
        binding.ingredientsAddContainer.addView(view.root)

        view.deleteIngredientBtn.setOnClickListener {
            binding.ingredientsAddContainer.removeView(view.root)
        }
    }

    private fun addCategoriesCheckBoxes() {
        Category.values().forEach { category ->

            val newView = CategoryCheckBoxBinding.inflate(layoutInflater)
            binding.categoriesCheckboxContainer.addView(newView.root)

            newView.checkbox.text = category.title
            newView.checkbox.contentDescription = category.name

            checkBoxList.add(newView.checkbox)
        }
    }

    private fun showSaveRecipeDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.save_recipe)
            .setPositiveButton(R.string.save) { _, _ ->
                saveRecipe()

                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun saveRecipe() {
        val categoriesToAdd = mutableListOf<String>()

        checkBoxList.forEach { checkBox ->
            if (checkBox.isChecked)
                categoriesToAdd.add(checkBox.contentDescription.toString())
        }


        val newRecipe = Recipe(
            id = "",
            title = binding.titleAddEt.text.toString(),
            image = binding.imageUrlAddEt.text.toString(),
            ingredients = listOf(

            ),
            rawCategories = categoriesToAdd,
            instructions = binding.instructionsAddEt.text.toString(),
            favorite = favorite
        )

        runBlocking {
            ApiRest.client.addRecipe(newRecipe)
        }
    }
}