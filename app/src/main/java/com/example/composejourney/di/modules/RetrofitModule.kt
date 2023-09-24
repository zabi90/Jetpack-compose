package com.example.composejourney.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    companion object {
        const val PUBLIC_CLIENT = "publicClient"
        const val AUTH_CLIENT = "authClient"
    }

    @Provides
    fun getRetrofit(): Retrofit {

        val logging = HttpLoggingInterceptor()

        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor { chain: Interceptor.Chain ->

            val request: Request = chain.request()
                .newBuilder()
                .build()

            chain.proceed(request)
        }


//        if (BuildConfig.DEBUG) {
//            client.addInterceptor(logging)
//        }
        client.connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }
}