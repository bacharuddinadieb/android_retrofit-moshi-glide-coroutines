package org.d3if0113.jurnal09

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0113.jurnal09.detailwithgambar.DetailWithGambarAdapter
import org.d3if0113.jurnal09.detailwithoutgambar.DetailWithoutGambarAdapter
import org.d3if0113.jurnal09.home.HomeAdapter
import org.d3if0113.jurnal09.network.MiwokProperty
import org.d3if0113.jurnal09.network.WordList

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MiwokProperty>?) {
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataWithoutGambar")
fun bindRecyclerView2(recyclerView: RecyclerView, data: List<WordList>?) {
    val adapter = recyclerView.adapter as DetailWithoutGambarAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataWithGambar")
fun bindRecyclerView3(recyclerView: RecyclerView, data: List<WordList>?) {
    val adapter = recyclerView.adapter as DetailWithGambarAdapter
    adapter.submitList(data)
    Log.i("binding adapter", "${data?.size} data")
}