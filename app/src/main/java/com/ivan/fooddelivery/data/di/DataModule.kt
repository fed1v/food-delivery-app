package com.ivan.fooddelivery.data.di

import android.content.Context
import androidx.room.Room
import com.ivan.fooddelivery.data.database.AppDatabase
import com.ivan.fooddelivery.data.database.dao.CategoryDao
import com.ivan.fooddelivery.data.database.dao.FoodDao
import com.ivan.fooddelivery.data.remote.FoodApiService
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
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(FoodApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(
        database: AppDatabase
    ): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    @Singleton
    fun provideFoodDao(
        database: AppDatabase
    ): FoodDao {
        return database.foodDao()
    }

    @Provides
    @Singleton
    fun provideFoodApiService(retrofit: Retrofit): FoodApiService {
        return retrofit.create(FoodApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideBannerRepository(): BannerRepository {
        return BannerRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideFoodRepository(apiService: FoodApiService, foodDao: FoodDao): FoodRepository {
        return FoodRepositoryImpl(apiService, foodDao)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(
        apiService: FoodApiService,
        categoryDao: CategoryDao
    ): CategoryRepository {
        return CategoryRepositoryImpl(apiService, categoryDao)
    }

    @Provides
    @Singleton
    fun provideCityRepository(): CityRepository {
        return CityRepositoryImpl()
    }
}