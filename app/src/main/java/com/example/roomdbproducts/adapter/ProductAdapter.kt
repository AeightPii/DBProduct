package com.example.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbproducts.R
import com.example.roomdbproducts.entity.Product
import kotlinx.android.synthetic.main.item_products.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.WordViewHolder>() {

    private var products = emptyList<Product>()

    inner class WordViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.txt_id.text = product.id.toString()
            itemView.txt_name.text = product.name
            itemView.txt_price.text=product.price.toString()
            itemView.txt_quantity.text=product.quantity.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun setWords(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
}