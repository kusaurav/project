package com.example.app

import retrofit2.http.Url

data class productDetails(
    var sku: String,
    var name: String,
    var productid:Int,
    var price:Int,
    var url1: String,
    var url2: String,
    var url3:String
)