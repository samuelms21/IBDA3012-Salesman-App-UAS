package id.ac.ibda.pads.proyekuas.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ac.ibda.pads.proyekuas.Model.ProductModel
import id.ac.ibda.pads.proyekuas.databinding.ProductListBinding


class HomepageAdapter (var productList: MutableLiveData<List<ProductModel>>) : RecyclerView.Adapter<HomepageAdapter.HomepageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomepageViewHolder {
        val binding = ProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomepageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.value?.size ?: 0
    }

    class HomepageViewHolder(private val binding:ProductListBinding) : RecyclerView.ViewHolder(binding.root){
        private val itemImage = binding.productImage
        fun bind(product: ProductModel) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(product.img_src)
                    .into(itemImage)
            }
        }

        val productName = binding.productName
        var productQty = binding.availableQuantity
        var price = binding.productPrice
    }

    override fun onBindViewHolder(holder: HomepageViewHolder, position: Int) {
        val currentItem = productList.value?.get(position)
        if (currentItem != null) {
            holder.bind(currentItem)
            holder.productName.text = currentItem.name.toString()
            holder.productQty.text = currentItem.available_qty.toString()
            holder.price.text = currentItem.price.toString()
        }
    }


}