package com.ivan.fooddelivery.data.di

import com.ivan.fooddelivery.data.repository.BannerRepositoryImpl
import com.ivan.fooddelivery.data.repository.CategoryRepositoryImpl
import com.ivan.fooddelivery.data.repository.CityRepositoryImpl
import com.ivan.fooddelivery.data.repository.FoodRepositoryImpl
import com.ivan.fooddelivery.domain.repository.BannerRepository
import com.ivan.fooddelivery.domain.repository.CategoryRepository
import com.ivan.fooddelivery.domain.repository.CityRepository
import com.ivan.fooddelivery.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideBannerRepository(): BannerRepository {
        return BannerRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideFoodRepository(): FoodRepository {
        return FoodRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(): CategoryRepository {
        return CategoryRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCityRepository(): CityRepository{
        return CityRepositoryImpl()
    }
}