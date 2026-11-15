package com.starchild13.retrofitem.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.starchild13.retrofitem.domain.APIService
import com.starchild13.retrofitem.domain.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Hilt module that provides dependency injection configurations for network and repository instances.
 * Installed in [SingletonComponent] to ensure provided instances live for the application lifetime.
 */
@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    /**
     * Provides a singleton instance of [Retrofit] configured with Kotlinx Serialization.
     *
     * @return Configured [Retrofit] HTTP client builder instance.
     */
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        return Retrofit.Builder()
            .baseUrl("https://thesimpsonsapi.com/api/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    /**
     * Provides a singleton instance of [APIService] for API network operations.
     *
     * @param retrofit The [Retrofit] instance used to create the service implementation.
     * @return Initialized [APIService] interface proxy.
     */
    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    /**
     * Provides a singleton instance of [RepositoryImpl] to handle network data access.
     *
     * @param apiService The [APIService] dependency required by [RepositoryImpl].
     * @return Initialized [RepositoryImpl] instance.
     */
    @Provides
    @Singleton
    fun providesRepository(apiService: APIService): RepositoryImpl {
        return RepositoryImpl(apiService = apiService)
    }
}
