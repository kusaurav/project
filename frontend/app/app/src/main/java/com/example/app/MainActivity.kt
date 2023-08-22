package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: APIService
    private lateinit var productAdapter: ProductAdapter

    private var products = listOf<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        apiService = APIConfig.getRetrofitClient(this).create(APIService::class.java)
        findViewById<RecyclerView>(R.id.products_recyclerview).layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        getProducts()
    }


    private fun getProducts() {
        apiService.getProducts().enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                print(t.message)
                t.message?.let { Log.d("Data error", it) }
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                products = response.body()!!
                productAdapter = ProductAdapter(this@MainActivity, products)
                findViewById<RecyclerView>(R.id.products_recyclerview).adapter = productAdapter
            }
        }
        )
    }
}