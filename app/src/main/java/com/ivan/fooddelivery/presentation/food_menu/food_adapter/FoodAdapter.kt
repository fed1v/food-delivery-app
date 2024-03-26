package com.ivan.fooddelivery.presentation.food_menu.food_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivan.fooddelivery.databinding.ItemFoodBinding
import com.ivan.fooddelivery.presentation.models.Food

class FoodAdapter(
    private val foodList: List<Food>,
    private val onFoodClicked: (Food) -> Unit,
    private val onPriceClicked: (Food) -> Unit
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
        private val onFoodClicked: (Food) -> Unit,
        private val onPriceClicked: (Food) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Food) {
            binding.imageViewPizza.setImageResource(food.imageResource)
            binding.textViewTitle.text = food.title
            binding.textViewDescription.text = food.description
            binding.textViewPrice.text = food.price.toInt().toString()

            binding.root.setOnClickListener {
                onFoodClicked(food)
            }

            binding.cardPrice.setOnClickListener {
                onPriceClicked(food)
            }
        }
    }
}