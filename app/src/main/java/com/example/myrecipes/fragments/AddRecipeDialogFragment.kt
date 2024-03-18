package com.example.myrecipes.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myrecipes.R
import com.example.myrecipes.databinding.FragmentAddRecipeBinding
import com.example.myrecipes.databinding.IngredientAddLayoutBinding


class AddRecipeDialogFragment : DialogFragment(R.layout.fragment_add_recipe) {
    private lateinit var binding: FragmentAddRecipeBinding
    private var liked = false
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddRecipeBinding.bind(view)

        repeat(2) {
            addIngredientField()
        }

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
            }
        }

        binding.likeBtnInAddRecipe.setOnClickListener {
            if (liked) {
                binding.likeBtnInAddRecipe.setIconResource(R.drawable.ic_empty_like)
                liked = false
            } else {
                binding.likeBtnInAddRecipe.setIconResource(R.drawable.ic_like)
                liked = true
            }
        }

    }

    private fun addIngredientField() {
        val view = IngredientAddLayoutBinding.inflate(layoutInflater)
        binding.ingredientsAddContainer.addView(view.root)

        view.deleteIngredientBtn.setOnClickListener {
            binding.ingredientsAddContainer.removeView(view.root)
        }
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window!!.setLayout(width, height)
        }
    }

    companion object {
        const val TAG = "TAG_Dialog"
    }
}