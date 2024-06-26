package com.ivan.fooddelivery.presentation.food_menu.food_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.databinding.ItemFoodBinding
import com.ivan.fooddelivery.presentation.models.FoodPresentation

class FoodAdapter(
    private val foodList: List<FoodPresentation>,
    private val onFoodClicked: (FoodPresentation) -> Unit,
    private val onPriceClicked: (FoodPresentation) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding, onFoodClicked, onPriceClicked)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int = foodList.size

    class FoodViewHolder(
        private val binding: ItemFoodBinding,
        private val onFoodClicked: (FoodPresentation) -> Unit,
        private val onPriceClicked: (FoodPresentation) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(food: FoodPresentation) {

            Glide
                .with(binding.root.context)
                .load(food.imageLink)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.color.white)
                .error(R.color.white)
                .into(binding.imageViewPizza)

            binding.textViewTitle.text = food.title
            binding.textViewDescription.text = food.ingredients
            binding.textViewPrice.text = food.price

            binding.root.setOnClickListener {
                onFoodClicked(food)
            }

            binding.cardPrice.setOnClickListener {
                onPriceClicked(food)
            }
        }
    }
}