package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ibda.pads.proyekuas.Adapter.RecyclerAdapter
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.ViewModel.HomepageVM
import id.ac.ibda.pads.proyekuas.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var homepageVM: HomepageVM
    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        homepageVM = ViewModelProvider(requireActivity())[HomepageVM::class.java]

        val view = binding.root
        homepageVM.getProducts()

        recyclerAdapter = RecyclerAdapter()
        binding.productsRecyclerView.adapter = recyclerAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.productsRecyclerView.layoutManager = layoutManager

        homepageVM.observeItemList(recyclerAdapter)
    }

}