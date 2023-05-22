package id.ac.ibda.pads.proyekuas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ibda.pads.proyekuas.R
import id.ac.ibda.pads.proyekuas.ViewModel.HomepageVM
import id.ac.ibda.pads.proyekuas.databinding.FragmentHomepageBinding


class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var homepageVM: HomepageVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }
}