package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ibda.pads.proyekuas.Adapter.RecyclerAdapter
import id.ac.ibda.pads.proyekuas.Model.ProductModel
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.ViewModel.HomepageVM
import id.ac.ibda.pads.proyekuas.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment(), RecyclerAdapter.ItemButtonClickListener {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var homepageVM: HomepageVM
    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        homepageVM = ViewModelProvider(requireActivity())[HomepageVM::class.java]

        val view = binding.root
        homepageVM.getProducts()

        recyclerAdapter = RecyclerAdapter()
        recyclerAdapter.setItemButtonClickListener(this)
        binding.productsRecyclerView.adapter = recyclerAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.shoppingCart -> {
                    Navigation.findNavController(view).navigate(R.id.action_homepageFragment_to_shoppingCartFragment2)
                    true
                }
                else -> {
                    false
                }
            }
        }

        val layoutManager = LinearLayoutManager(requireContext())
        binding.productsRecyclerView.layoutManager = layoutManager
        homepageVM.observeItemList(recyclerAdapter)
    }

    override fun onItemButtonClicked(position: Int, qty: Int, product: ProductModel) {
        Log.d("ADD_TO_CART_FRAGMENT", "ProductID: ${product.id}, Quantity: $qty")
        homepageVM.addToCart(position, qty, product)
    }

}