package com.mcua.architecture.core.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mcua.architecture.BuildConfig
import com.mcua.architecture.core.data.api.ApiService
import com.mcua.architecture.core.util.network.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = "http://192.168.1.3:3000/"

    @Singleton
    @Provides
    @Named("ApiGson")
    fun providesGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    @Named("ApiInterceptor")
    fun providesApiNetworkInterceptor(): Interceptor {
        return NetworkInterceptor()
    }

    @Singleton
    @Provides
    @Named("ApiOkHttp")
    fun providesApiOkHttp(@Named("ApiInterceptor") interceptor: Interceptor): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logger.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logger.level = HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor(interceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Singleton
    @Provides
    @Named("ApiRetrofit")
    fun provideRetrofit(@Named("ApiOkHttp") okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(@Named("ApiRetrofit") retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}