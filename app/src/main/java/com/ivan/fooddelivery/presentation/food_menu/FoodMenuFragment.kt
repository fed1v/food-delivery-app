package com.ivan.fooddelivery.presentation.food_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.databinding.FragmentFoodMenuBinding
import com.ivan.fooddelivery.presentation.food_menu.banner_adapter.BannerAdapter
import com.ivan.fooddelivery.presentation.food_menu.category_adapter.CategoryAdapter
import com.ivan.fooddelivery.presentation.food_menu.food_adapter.FoodAdapter
import com.ivan.fooddelivery.presentation.models.Banner
import com.ivan.fooddelivery.presentation.models.Category
import com.ivan.fooddelivery.presentation.models.Food


class FoodMenuFragment : Fragment() {

    private lateinit var binding: FragmentFoodMenuBinding

    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var foodAdapter: FoodAdapter

    private val onBannerClicked = { banner: Banner ->
        Toast.makeText(requireContext(), "banner ${banner.id} clicked", Toast.LENGTH_SHORT).show()
    }

    private val onCategoryClicked = { category: Category ->
        Toast.makeText(requireContext(), "category ${category.name} clicked", Toast.LENGTH_SHORT)
            .show()
    }

    private val onFoodClicked = { food: Food ->
        Toast.makeText(requireContext(), "food ${food.title} clicked", Toast.LENGTH_SHORT)
            .show()
    }

    private val onFoodPriceClicked = { food: Food ->
        Toast.makeText(requireContext(), "food ${food.title} ordered", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val banners = listOf(
            Banner(1, R.drawable.image_banner_1),
            Banner(2, R.drawable.image_banner_2),
            Banner(3, R.drawable.image_banner_1),
        )

        initBannerRecyclerView(banners)

        val categories = listOf(
            Category(1, "Пицца"),
            Category(2, "Комбо"),
            Category(3, "Десерты"),
            Category(4, "Напитки"),
            Category(5, "Завтраки"),
            Category(6, "Обеды"),
        )

        initCategoriesRecyclerView(categories)

        val foodList = (1..5).map {
            Food(
                it,
                R.drawable.image_pizza,
                "Pizza$it",
                "Description$it",
                100.0 * it
            )
        }

        initFoodAdapter(foodList)
    }

    private fun initBannerRecyclerView(banners: List<Banner>) {
        bannerAdapter = BannerAdapter(banners, onBannerClicked)
        binding.recyclerViewBanners.adapter = bannerAdapter
    }

    private fun initCategoriesRecyclerView(categories: List<Category>) {
        categoryAdapter = CategoryAdapter(categories, onCategoryClicked)
        binding.recyclerViewCategories.adapter = categoryAdapter
    }

    private fun initFoodAdapter(foodList: List<Food>) {
        foodAdapter = FoodAdapter(
            foodList = foodList,
            onFoodClicked = onFoodClicked,
            onPriceClicked = onFoodPriceClicked
        )

        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)

        ContextCompat.getDrawable(requireContext(), R.drawable.line_divider)?.let {
            divider.setDrawable(it)
        }

        binding.recyclerViewFood.addItemDecoration(divider)
        binding.recyclerViewFood.adapter = foodAdapter
    }
}