package org.d3if0113.jurnal09.detailwithgambar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.d3if0113.jurnal09.R
import org.d3if0113.jurnal09.databinding.FragmentDetailWithGambarBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailWithGambarFragment : Fragment() {

    private lateinit var binding: FragmentDetailWithGambarBinding
    private val viewModel: DetailWithGambarViewModel by lazy {
        ViewModelProviders.of(this).get(DetailWithGambarViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val args = arguments?.let { DetailWithGambarFragmentArgs.fromBundle(it) }
        Log.i("parcelWith", args?.SELECTEDPROPERTYKEY?.category)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_with_gambar,
            container,
            false
        )
        binding.lifecycleOwner = this
        viewModel.setMiwokData(args!!.SELECTEDPROPERTYKEY.wordList)
        binding.viewModel = viewModel
        binding.rvDetailWithGambar.adapter = DetailWithGambarAdapter()
        return binding.root
    }

}
