package org.d3if0113.jurnal09.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import org.d3if0113.jurnal09.R
import org.d3if0113.jurnal09.databinding.FragmentHomeBinding
import org.d3if0113.jurnal09.network.MiwokV2

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

//        dataBinding.rvHome.adapter = HomeAdapter(HomeAdapter.HomeListener { miwokProperty ->
//            viewModel.onItemHomeDitekan(miwokProperty)
//        })

        dataBinding.rvHome.adapter = HomeAdapterV2(HomeAdapterV2.HomeListener { miwokV2 ->
            viewModel.onItemHomeDitekanV2(miwokV2)
        })

//        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                var miwokProperty = it
//                if (miwokProperty.wordList[0].image == "kosong") {
//                    this.findNavController().navigate(
//                        HomeFragmentDirections.actionHomeFragmentToDetailWithoutGambarFragment(
//                            miwokProperty,
//                            viewModel.miwokV2.value?.get(0)!!
//                        )
//                    )
//                } else {
//                    this.findNavController().navigate(
//                        HomeFragmentDirections.actionHomeFragmentToDetailWithGambarFragment(
//                            miwokProperty,
//                            viewModel.miwokV2.value?.get(0)!!
//                        )
//                    )
//                }
//                viewModel.onItemHomeSudahDitekan()
//            }
//        })

        viewModel.miwokV2.observe(viewLifecycleOwner, Observer {
            it.let {
                Log.i("observerMiwokv2!", it.toString())
            }
        })

        viewModel.navigateToDetailV2.observe(viewLifecycleOwner, Observer {
            it?.let {
                var miwokV2 = it
                var listMiwokV2Sementara: MutableList<MiwokV2> = mutableListOf()
                for (item in viewModel.miwokV2.value!!) {
                    if (item.category.equals(miwokV2.category)) {
                        listMiwokV2Sementara.add(item)
                    }
                }
                if (miwokV2.image == "kosong") {
                    this.findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailWithoutGambarFragment(
                            miwokV2,
                            listMiwokV2Sementara.toTypedArray()
                        )
                    )
                    Log.i("navigateToDetailV2", "${miwokV2.category} + ${miwokV2.imageURL}")
                } else {
                    this.findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailWithGambarFragment(
                            miwokV2,
                            listMiwokV2Sementara.toTypedArray()
                        )
                    )
                    Log.i("navigateToDetailV2", "${miwokV2.category} + ${miwokV2.imageURL}")
                }
                viewModel.onItemHomeSudahDitekan()
            }
        })

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (viewModel.response.value == "loaded") {
                    hideLoader()
                } else if (viewModel.response.value == ("loadedLocal")) {
                    Toast.makeText(context, "Mengambil data local", Toast.LENGTH_LONG).show()
                    hideLoader()
                } else if (viewModel.response.value!!.contains("Gagal")) {
                    Toast.makeText(context, "Anda Offline! :(", Toast.LENGTH_LONG).show()
                    dataBinding.tvLaoding.text = "Gagal memuat data :("
                }
            }
        })

        return dataBinding.root
    }

    fun hideLoader() {
        dataBinding.pbLoading.visibility = View.GONE
        dataBinding.tvLaoding.visibility = View.GONE
        dataBinding.rvHome.visibility = View.VISIBLE
        Log.i("visibility", "visible")
    }

}
