package com.example.authme2.interfaces


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://www.superheroapi.com/api.php/5165150593500818/"

class ApiInterfaceBuilder {
    companion object {
        var apiInterfaceService: ApiInterfaceService? = null
        var okHttpClient: OkHttpClient? = null

        fun getApiInterface(): ApiInterfaceService? {
            if (apiInterfaceService == null) {

                //For printing API url and body in logcat
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(50, TimeUnit.SECONDS)
                    .writeTimeout(50, TimeUnit.SECONDS)
                    .callTimeout(50, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                apiInterfaceService = retrofit.create(ApiInterfaceService::class.java)
            }

            return apiInterfaceService
        }
    }
}