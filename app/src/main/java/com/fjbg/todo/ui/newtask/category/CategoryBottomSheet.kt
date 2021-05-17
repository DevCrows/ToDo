package com.fjbg.todo.ui.newtask.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.databinding.BottomSheetCategoryBinding
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryBottomSheet(
    val viewModel: TaskViewModel,
) : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "CategoryBottomSheet"
    }

    private lateinit var binding: BottomSheetCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetCategoryBinding.inflate(inflater, parent, false)
        initUi()
        return binding.root
    }

    private fun initUi() {
        binding.btnSaveCategory.setOnClickListener {
            lifecycleScope.launchWhenResumed {
                saveCategory(
                    Category(
                        id = 0,
                        name = binding.etCategory.text.toString(),
                        color = "FF00FF"
                    )
                )
            }
        }
    }

    private fun saveCategory(category: Category) {
        lifecycleScope.launchWhenResumed {
            viewModel.addCategory(category)
            binding.etCategory.text?.clear()
        }
    }
}