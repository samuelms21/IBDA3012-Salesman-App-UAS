package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.Utils.AccessTokenManager
import id.ac.ibda.pads.proyekuas.Utils.RetrofitObject
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

        binding.loginButton.setOnClickListener {
            val username = binding.salesPersonUsernameField.text.toString().trim()
            val password = binding.salesPersonPasswordField.text.toString().trim()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginVM.login(username, password)
                AccessTokenManager.getAccessToken { token ->
                    if (token != null) {
                        Log.d("FRAGMENT_LOGIN", token)
                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homepageFragment)
                    } else {
                        Log.d("FRAGMENT_LOGIN", "LOADING TOKEN....")
                    }
                }
            } else {
                // Handle empty fields
                if (username.isEmpty()) {
                    binding.salesPersonUsernameField.error = "Username cannot be empty"
                }
                if (password.isEmpty()) {
                    binding.salesPersonPasswordField.error = "Password cannot be empty"
                }
            }
        }

        return view
    }

}