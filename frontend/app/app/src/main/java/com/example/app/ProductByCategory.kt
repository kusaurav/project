package com.example.app

class ProductByCategory {
    private lateinit var apiService: APIService
    private lateinit var productAdapter: ProductAdapter
    private var products = listOf<Product>()
}