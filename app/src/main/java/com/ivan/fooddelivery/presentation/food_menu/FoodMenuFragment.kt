package com.ivan.fooddelivery.presentation.food_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.databinding.FragmentFoodMenuBinding
import com.ivan.fooddelivery.presentation.food_menu.banner_adapter.BannerAdapter
import com.ivan.fooddelivery.presentation.food_menu.category_adapter.CategoryAdapter
import com.ivan.fooddelivery.presentation.food_menu.food_adapter.FoodAdapter
import com.ivan.fooddelivery.presentation.models.BannerPresentation
import com.ivan.fooddelivery.presentation.models.CategoryPresentation
import com.ivan.fooddelivery.presentation.models.FoodPresentation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class FoodMenuFragment : Fragment() {

    private lateinit var binding: FragmentFoodMenuBinding

    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var foodAdapter: FoodAdapter

    private val viewModel: FoodMenuViewModel by viewModels()

    private val onBannerClicked = { banner: BannerPresentation ->
        Toast.makeText(requireContext(), "banner ${banner.id} clicked", Toast.LENGTH_SHORT).show()
    }

    private val onCategoryClicked = { category: CategoryPresentation ->
        Toast.makeText(requireContext(), "category ${category.name} clicked", Toast.LENGTH_SHORT)
            .show()
    }

    private val onFoodClicked = { food: FoodPresentation ->
        Toast.makeText(requireContext(), "food ${food.title} clicked", Toast.LENGTH_SHORT)
            .show()

        findNavController().navigate(R.id.action_menuFragment_to_foodDetailsFragment)
    }

    private val onFoodPriceClicked = { food: FoodPresentation ->
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

        lifecycleScope.launch {

            withContext(Dispatchers.Main){
                viewModel.bannersLiveData.observe(viewLifecycleOwner) {
                    initBannerRecyclerView(it)
                }

                viewModel.categoriesLiveData.observe(viewLifecycleOwner) {
                    initCategoriesRecyclerView(it)
                }

                viewModel.foodListLiveData.observe(viewLifecycleOwner) {
                    initFoodRecyclerView(it)
                }

                viewModel.citiesLiveData.observe(viewLifecycleOwner) {
                    // TODO
                }
            }
        }
    }

    private fun initBannerRecyclerView(banners: List<BannerPresentation>) {
        bannerAdapter = BannerAdapter(banners, onBannerClicked)
        binding.recyclerViewBanners.adapter = bannerAdapter
    }

    private fun initCategoriesRecyclerView(categories: List<CategoryPresentation>) {
        categoryAdapter = CategoryAdapter(categories, onCategoryClicked)
        binding.recyclerViewCategories.adapter = categoryAdapter
    }

    private fun initFoodRecyclerView(foodList: List<FoodPresentation>) {
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