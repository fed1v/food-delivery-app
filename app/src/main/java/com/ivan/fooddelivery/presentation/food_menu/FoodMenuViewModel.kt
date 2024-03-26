package com.ivan.fooddelivery.presentation.food_menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivan.fooddelivery.domain.usecases.banners.GetBannersUseCase
import com.ivan.fooddelivery.domain.usecases.banners.GetCategoriesUseCase
import com.ivan.fooddelivery.domain.usecases.banners.GetFoodListUseCase
import com.ivan.fooddelivery.presentation.models.BannerPresentation
import com.ivan.fooddelivery.presentation.models.CategoryPresentation
import com.ivan.fooddelivery.presentation.models.CityPresentation
import com.ivan.fooddelivery.presentation.models.FoodPresentation
import com.ivan.fooddelivery.presentation.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodMenuViewModel @Inject constructor(
    private val getBannersUseCase: GetBannersUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getFoodListUseCase: GetFoodListUseCase,
) : ViewModel() {

    private var _bannersLiveData = MutableLiveData<List<BannerPresentation>>()
    val bannersLiveData: LiveData<List<BannerPresentation>> = _bannersLiveData

    private var _categoriesLiveData = MutableLiveData<List<CategoryPresentation>>()
    val categoriesLiveData: LiveData<List<CategoryPresentation>> = _categoriesLiveData

    private var _foodListLiveData = MutableLiveData<List<FoodPresentation>>()
    val foodListLiveData: LiveData<List<FoodPresentation>> = _foodListLiveData

    private var _citiesLiveData = MutableLiveData<List<CityPresentation>>()
    val citiesLiveData: LiveData<List<CityPresentation>> = _citiesLiveData


    init {
        _bannersLiveData.value = getBannersUseCase().map { it.toPresentation() }
        _categoriesLiveData.value = getCategoriesUseCase().map { it.toPresentation() }
        _foodListLiveData.value = getFoodListUseCase().map { it.toPresentation() }
    }
}