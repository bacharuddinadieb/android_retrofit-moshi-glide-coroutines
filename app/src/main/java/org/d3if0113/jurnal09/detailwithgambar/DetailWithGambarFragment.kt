package org.d3if0113.jurnal09.detailwithgambar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
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
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_with_gambar,
            container,
            false
        )
        binding.lifecycleOwner = this
        viewModel.setMiwokData(args!!.SELECTEDPROPERTYDATAV2.toList())
        binding.viewModel = viewModel
        binding.rvDetailWithGambar.adapter = DetailWithGambarAdapter()
        binding.backgroundParsedColorDrawable =
            ColorDrawable(Color.parseColor(args.SELECTEDPROPERTYKEYV2.background))
        return binding.root
    }

}
