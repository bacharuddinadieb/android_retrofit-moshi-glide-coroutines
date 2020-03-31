package org.d3if0113.jurnal09.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import org.d3if0113.jurnal09.R
import org.d3if0113.jurnal09.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var dataBinding: FragmentHomeBinding
    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        dataBinding.lifecycleOwner = this
        dataBinding.viewModel = viewModel

        dataBinding.rvHome.adapter = HomeAdapter(HomeAdapter.HomeListener { miwokProperty ->
            viewModel.onItemHomeDitekan(miwokProperty)
        })

        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer {
            it?.let {
                var miwokProperty = it
                if (miwokProperty.wordList[0].image == "kosong") {
                    this.findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailWithoutGambarFragment(
                            miwokProperty
                        )
                    )
                } else {
                    this.findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailWithGambarFragment(
                            miwokProperty
                        )
                    )
                }
                viewModel.onItemHomeSudahDitekan()
            }
        })

        return dataBinding.root
    }

}
