package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import id.ac.ibda.pads.proyekuas.Adapter.ShoppingCartListAdapter
import id.ac.ibda.pads.proyekuas.Model.CartItem
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.Utils.ShoppingCart
import id.ac.ibda.pads.proyekuas.ViewModel.HomepageVM
import id.ac.ibda.pads.proyekuas.ViewModel.ShoppingCartVM
import id.ac.ibda.pads.proyekuas.databinding.FragmentHomepageBinding
import id.ac.ibda.pads.proyekuas.databinding.FragmentShoppingCartBinding

class ShoppingCartFragment : Fragment() {

    private lateinit var binding: FragmentShoppingCartBinding
    private lateinit var shoppingCartVM: ShoppingCartVM
    private lateinit var shoppingCartListAdapter: ShoppingCartListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        shoppingCartVM = ViewModelProvider(requireActivity())[ShoppingCartVM::class.java]
        val view = binding.root

        shoppingCartListAdapter = ShoppingCartListAdapter()
        binding.cartItemsRecyclerView.adapter = shoppingCartListAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homepage -> {
                    Navigation.findNavController(view).navigate(R.id.action_shoppingCartFragment2_to_homepageFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }

        val layoutManager = LinearLayoutManager(requireContext())
        binding.cartItemsRecyclerView.layoutManager = layoutManager
        binding.totalCartPrice.text = "Total Order\n$${shoppingCartVM.getCartTotalPrice()}"
        val itemCount = shoppingCartVM.getCartItemCount()
        if (itemCount > 0) {
            binding.pickCustomerButton.isEnabled = true
        } else {
            binding.pickCustomerButton.isEnabled = false
        }

        binding.clearCartButton.setOnClickListener {
            shoppingCartVM.clearCart()
            binding.pickCustomerButton.isEnabled = false
        }

        val navController = findNavController()
        binding.pickCustomerButton.setOnClickListener {
            navController.navigate(R.id.action_shoppingCartFragment2_to_pickCustomerFragment)
        }
    }
}