package org.d3if0113.jurnal09.detailwithoutgambar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0113.jurnal09.R

/**
 * A simple [Fragment] subclass.
 */
class DetailWithoutGambarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_without_gambar, container, false)
    }

}
