package org.d3if0113.jurnal09

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0113.jurnal09.home.HomeAdapter
import org.d3if0113.jurnal09.network.MiwokProperty

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MiwokProperty>?) {
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(data)
}