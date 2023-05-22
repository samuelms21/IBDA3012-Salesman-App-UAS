package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.ViewModel.LoginVM
import id.ac.ibda.pads.proyekuas.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginVM: LoginVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize binding, VM, & navController
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginVM = ViewModelProvider(requireActivity())[LoginVM::class.java]

        val view = binding.root


        // ######### CODE START HERE #########
//        val spUsername = binding.salesPersonUsernameField.text.toString()
//        val spPassword = binding.salesPersonPasswordField.text.toString()

        binding.loginButton.setOnClickListener {
            val username = binding.salesPersonUsernameField.text.toString()
            val password = binding.salesPersonPasswordField.text.toString()
            Log.d("TEST_LOGIN", "Username: ${username}, Password: ${password}")

            val navController = view.findNavController()
            navController.navigate(R.id.action_loginFragment_to_homepageFragment)  // navigate to other fragment
        }

//        loginVM.salesperson.observe(viewLifecycleOwner, Observer {
//            binding.textView.text = it.id.toString()
//        })

        // ########## CODE END HERE ##########

        return view
    }

}