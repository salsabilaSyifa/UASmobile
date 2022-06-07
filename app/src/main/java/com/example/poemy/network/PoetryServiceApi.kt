package com.example.poemy.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://poetrydb.org"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PoetryServiceApi{
    @GET("/author/Percy Bysshe Shelley")
    suspend fun getData() : List<Poetry>
}

interface Poetry1ServiceApi{
    @GET("/author/Amy Levy")
    suspend fun getData1() : List<Poetry1>
}

object PoetryApi{
    val retrofitServiceApi : PoetryServiceApi by lazy {
        retrofit.create(PoetryServiceApi::class.java)
    }
}

object Poetry1Api{
    val retrofitServiceApi1 : Poetry1ServiceApi by lazy {
        retrofit.create(Poetry1ServiceApi::class.java)
    }
}
