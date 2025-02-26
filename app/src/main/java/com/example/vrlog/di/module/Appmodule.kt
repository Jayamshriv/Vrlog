package com.example.vrlog.di.module

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.vrlog.core.utils.Constants
import com.example.vrlog.core.utils.NetworkHelper
import com.example.vrlog.data.local.database.AppDatabase
import com.example.vrlog.data.local.dao.BlogsPostDao
import com.example.vrlog.data.remote.api.BlogApiService
import com.example.vrlog.data.repository.BlogsApiRepositoryImpl
import com.example.vrlog.domain.repository.BlogsApiRepository
import com.example.vrlog.domain.usecase.BlogsPostUseCase
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
object Appmodule{
    @Provides
    @Singleton
    fun providesApiService() : BlogApiService{
        return try {
                Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(BlogApiService::class.java)
        }catch (e:Exception){
            Log.d("Appmodule : Error ","${e.message}")
            throw IllegalStateException("Failed to create api instance", e)
        }
    }
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "posts_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideBlogsDataDao(appDatabase: AppDatabase): BlogsPostDao {
        return appDatabase.blogsDataDao()
    }

    @Provides
    @Singleton
    fun providesBlogApiRepository(apiService: BlogApiService, blogsDataDao: BlogsPostDao, networkHelper: NetworkHelper):BlogsApiRepository{
        return BlogsApiRepositoryImpl(apiService,blogsDataDao, networkHelper)
    }

    @Provides
    @Singleton
    fun providesBlogApiUseCase(repository: BlogsApiRepository):BlogsPostUseCase{
        return BlogsPostUseCase(repository)
    }

    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context) = NetworkHelper(context)

}