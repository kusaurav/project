package com.example.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri;
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(
    private var context: Context,
    private var products: List<Product> = arrayListOf()
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProductAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.product, parent, false)
//        view.setOnClickListener(clickListener)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(viewHolder: ProductAdapter.ViewHolder, position: Int) {
        viewHolder.bindProduct(products[position])
        (context as MainActivity).findViewById<CoordinatorLayout>(R.id.coordinator)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindProduct(product: Product) {
            itemView.findViewById<TextView>(R.id.product_name).text = product.name
            itemView.findViewById<TextView>(R.id.product_price).text = "Rs." + product.price.toString()
//    Glide.with(MainActivity())
//        .load(product.photo)
//        .into(itemView.findViewById<ImageView>(R.id.product_image));

            Picasso.get().load(Uri.parse(product.photo)).fit()
                .into(itemView.findViewById<ImageView>(R.id.product_image));
            //Picasso.get().load(product.photo[0].filename).fit().into(itemView.findViewById<ImageView>(R.id.product_image))
        }
    }

//    private val clickListener = OnClickListener {
//        if(it.context is Activity){
//            val intent = Intent(it.context, OtherActivity::class.java)
//            intent.putExtra("asda", "")
//            it.context.startActivity(intent)
//
//        }
//    }
}