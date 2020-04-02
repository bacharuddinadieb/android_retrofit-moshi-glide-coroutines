package org.d3if0113.jurnal09.detailwithoutgambar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.d3if0113.jurnal09.R
import org.d3if0113.jurnal09.databinding.FragmentDetailWithoutGambarBinding
import org.d3if0113.jurnal09.detailwithgambar.DetailWithGambarFragmentArgs

/**
 * A simple [Fragment] subclass.
 */
class DetailWithoutGambarFragment : Fragment() {

    private lateinit var binding: FragmentDetailWithoutGambarBinding
    private val viewModel: DetailWithoutGambarViewModel by lazy {
        ViewModelProviders.of(this).get(DetailWithoutGambarViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val args = arguments?.let { DetailWithGambarFragmentArgs.fromBundle(it) }
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_without_gambar,
            container,
            false
        )
        binding.lifecycleOwner = this
        if (args != null) {
            viewModel.setMiwokData(args.SELECTEDPROPERTYKEY.wordList)
        }
        binding.viewModel = viewModel
        Log.i("atete", "${viewModel.wordList.value?.size} sizze")

        binding.rvDetailWithoutGambar.adapter = DetailWithoutGambarAdapter()

        binding.backgroundParsedColorDrawable =
            ColorDrawable(Color.parseColor(args?.SELECTEDPROPERTYKEY?.background))

        Log.i("parcelWithout", args?.SELECTEDPROPERTYKEY?.category)
        return binding.root
    }

}
