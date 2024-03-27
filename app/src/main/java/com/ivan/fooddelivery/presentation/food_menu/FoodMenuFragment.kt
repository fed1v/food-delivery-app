package com.ivan.fooddelivery.presentation.food_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.databinding.FragmentFoodMenuBinding
import com.ivan.fooddelivery.presentation.food_menu.banner_adapter.BannerAdapter
import com.ivan.fooddelivery.presentation.food_menu.category_adapter.CategoryAdapter
import com.ivan.fooddelivery.presentation.food_menu.food_adapter.FoodAdapter
import com.ivan.fooddelivery.presentation.models.BannerPresentation
import com.ivan.fooddelivery.presentation.models.CategoryPresentation
import com.ivan.fooddelivery.presentation.models.CityPresentation
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
    }

    private val onFoodPriceClicked = { food: FoodPresentation ->
        Toast.makeText(requireContext(), "food ${food.title} ordered", Toast.LENGTH_SHORT)
            .show()
    }

    private lateinit var cities: List<CityPresentation>

    private var city = "Москва"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardCity.setOnClickListener {
            openCityPicker(cities)
        }

        binding.buttonQrCode.setOnClickListener {
            Toast.makeText(requireContext(), "Scan QR code", Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                viewModel.bannersLiveData.observe(viewLifecycleOwner) {
                    initBannerRecyclerView(it)
                }
            }

            withContext(Dispatchers.Main) {
                viewModel.categoriesLiveData.observe(viewLifecycleOwner) {
                    initCategoriesRecyclerView(it)
                }
            }

            withContext(Dispatchers.Main) {
                viewModel.foodListLiveData.observe(viewLifecycleOwner) {
                    initFoodRecyclerView(it)
                }
            }

            withContext(Dispatchers.Main) {
                viewModel.citiesLiveData.observe(viewLifecycleOwner) {
                    setCity(it[0].name)
                    cities = it
                }
            }
        }

    }

    private fun openCityPicker(cities: List<CityPresentation>) {
        val cityNames = cities.map { it.name }.toTypedArray()

        AlertDialog.Builder(requireContext())
            .setTitle("Выберите город")
            .setItems(cityNames) { dialog, index ->
                setCity(cityNames[index])
            }
            .show()
    }

    private fun setCity(newCity: String) {
        city = newCity
        binding.textViewCity.text = city
        binding.cardCity.isVisible = true
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