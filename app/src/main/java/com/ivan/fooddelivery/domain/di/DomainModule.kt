package com.ivan.fooddelivery.domain.di

import com.ivan.fooddelivery.domain.repository.BannerRepository
import com.ivan.fooddelivery.domain.repository.CategoryRepository
import com.ivan.fooddelivery.domain.repository.CityRepository
import com.ivan.fooddelivery.domain.repository.FoodRepository
import com.ivan.fooddelivery.domain.usecases.banners.GetBannersUseCase
import com.ivan.fooddelivery.domain.usecases.banners.GetCategoriesUseCase
import com.ivan.fooddelivery.domain.usecases.banners.GetCitiesUseCase
import com.ivan.fooddelivery.domain.usecases.banners.GetFoodListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideGetBannersUseCase(bannerRepository: BannerRepository): GetBannersUseCase {
        return GetBannersUseCase(bannerRepository)
    }

    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(categoryRepository: CategoryRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideGetFoodListUseCase(foodRepository: FoodRepository): GetFoodListUseCase {
        return GetFoodListUseCase(foodRepository)
    }

    @Provides
    @Singleton
    fun provideGetCitiesUseCase(cityRepository: CityRepository): GetCitiesUseCase {
        return GetCitiesUseCase(cityRepository)
    }
}