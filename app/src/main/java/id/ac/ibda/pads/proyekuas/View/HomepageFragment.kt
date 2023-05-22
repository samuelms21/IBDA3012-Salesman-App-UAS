package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ibda.pads.proyekuas.Adapter.HomepageAdapter
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.ViewModel.HomepageVM
import id.ac.ibda.pads.proyekuas.ViewModel.LoginVM
import id.ac.ibda.pads.proyekuas.databinding.FragmentHomepageBinding
import id.ac.ibda.pads.proyekuas.databinding.FragmentLoginBinding


class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var homepageVM: HomepageVM
    private lateinit var homepageAdapter: HomepageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        homepageVM = ViewModelProvider(requireActivity())[HomepageVM::class.java]

        val view = binding.root

        homepageVM.getProducts()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setupRecyclerView()
    }

    private fun setupRecyclerView() = binding.recyclerviewDisplayItem.apply {
        homepageAdapter = HomepageAdapter(homepageVM.itemList)
        adapter = homepageAdapter
        layoutManager = LinearLayoutManager(context)
    }
}