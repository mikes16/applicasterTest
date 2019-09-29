package com.mikelop.applicastertest.common.di


import com.mikelop.applicastertest.BuildConfig
import com.mikelop.applicastertest.common.utils.NetworkHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    // declare factory instance for Controller class
    single { NetworkHandler(androidContext()) }
    single { provideRetrofitInterface() }
}

internal fun provideRetrofitInterface(): Retrofit {

    val okHttpClientBuilder = OkHttpClient.Builder()

    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
    }

    val okHttpClient = okHttpClientBuilder
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}