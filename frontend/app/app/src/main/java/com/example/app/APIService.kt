package com.example.app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("/")
    fun getProducts(): Call<List<Product>>

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("/category={category}")
    fun getProductsByCategory(): Call<List<Product>>

}