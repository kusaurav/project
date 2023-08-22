package com.example.app

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("category_id")
    var category_id:Int?=null,

    @SerializedName("price")
    var price: String? = null,

    @SerializedName("photo")
    var photo: String?=null,
)