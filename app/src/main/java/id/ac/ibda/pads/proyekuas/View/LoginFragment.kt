package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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
        // Initialize binding & VM
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginVM = ViewModelProvider(requireActivity())[LoginVM::class.java]

        val view = binding.root


        // ######### CODE START HERE #########
        val spUsername = binding.salesPersonUsernameField.text.toString()
        val spPassword = binding.salesPersonPasswordField.text.toString()

        binding.loginButton.setOnClickListener {
            val temp = loginVM.checkLogin(spUsername, spPassword).toString()
            binding.textView.text = temp
        }

        // ########## CODE END HERE ##########

        return view
    }

}