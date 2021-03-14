package com.example.madlevel4task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task1.databinding.ItemProductBinding

class ShoppingListAdapter(private val products: List<Product>) :
        RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemProductBinding.bind(itemView)

        // Specify which data in Product.kt corresponds to which TextViews.
        fun databind(product: Product) {
            binding.tvName.text = product.productName
            binding.tvQuantity.text = product.productQuantity.toString() + "X"
        }
    }

    // Create and return a ViewHolder object, inflate a standard layout called simple_list_item_1.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    // Return the size of the list.
    override fun getItemCount(): Int {
        return products.size
    }

    // Display the data at the specified position, called by RecyclerView.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(products[position])
    }
}