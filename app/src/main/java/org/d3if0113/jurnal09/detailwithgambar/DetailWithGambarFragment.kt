package org.d3if0113.jurnal09.detailwithgambar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0113.jurnal09.R

/**
 * A simple [Fragment] subclass.
 */
class DetailWithGambarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val args = arguments?.let { DetailWithGambarFragmentArgs.fromBundle(it) }
        Log.i("aheheheWith", args?.SELECTEDPROPERTYKEY?.category)
        return inflater.inflate(R.layout.fragment_detail_with_gambar, container, false)
    }

}
