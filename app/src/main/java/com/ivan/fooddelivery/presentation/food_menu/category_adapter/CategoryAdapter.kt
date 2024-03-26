package com.ivan.fooddelivery.presentation.food_menu.category_adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.databinding.ItemCategoryBinding
import com.ivan.fooddelivery.presentation.models.CategoryPresentation

open class CategoryAdapter(
    private val categories: List<CategoryPresentation>,
    private val onCategoryClicked: (CategoryPresentation) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var checkedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return CategoryViewHolder(binding, onCategoryClicked)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, checkedPosition)
    }

    override fun getItemCount(): Int = categories.size


    inner class CategoryViewHolder(
        private val binding: ItemCategoryBinding,
        private val onCategoryClicked: (CategoryPresentation) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: CategoryPresentation, checkedPosition: Int) {
            binding.textViewCategoryName.text = category.name

            binding.cardCategory.setOnClickListener {
                onCategoryClicked(category)
                setSelection(adapterPosition)
            }

            val foregroundColor: Int
            val textColor: Int
            val cardElevation: Float

            if (checkedPosition == adapterPosition) {
                foregroundColor = ContextCompat.getColor(
                    binding.root.context,
                    R.color.checked_category_background
                )

                textColor = ContextCompat.getColor(
                    binding.root.context,
                    R.color.checked_category_text_color
                )

                cardElevation = 0f

            } else {
                foregroundColor = ContextCompat.getColor(
                    binding.root.context,
                    android.R.color.transparent
                )

                textColor = ContextCompat.getColor(
                    binding.root.context,
                    R.color.text_color_gray
                )

                cardElevation = binding.root.resources.getDimension(R.dimen.default_card_elevation)
            }


            binding.cardCategory.setCardForegroundColor(
                ColorStateList.valueOf(foregroundColor)
            )

            binding.textViewCategoryName.setTextColor(textColor)
            binding.cardCategory.cardElevation = cardElevation
        }

        private fun setSelection(adapterPosition: Int) {
            if (adapterPosition == RecyclerView.NO_POSITION || adapterPosition == checkedPosition) {
                return;
            }

            notifyItemChanged(checkedPosition)
            checkedPosition = adapterPosition
            notifyItemChanged(checkedPosition)

            onViewRecycled(this)
        }
    }
}