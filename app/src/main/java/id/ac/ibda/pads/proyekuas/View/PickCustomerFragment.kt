package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.databinding.FragmentPickCustomerBinding

class PickCustomerFragment : Fragment() {

    private lateinit var binding: FragmentPickCustomerBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPickCustomerBinding.inflate(inflater, container, false)
        navController = findNavController()

        val view = binding.root


        // Back to Pick Customer Fragment
        binding.goBackToCartButton.setOnClickListener {
            navController.navigate(R.id.action_pickCustomerFragment_to_shoppingCartFragment2)
        }

        return view
    }

}