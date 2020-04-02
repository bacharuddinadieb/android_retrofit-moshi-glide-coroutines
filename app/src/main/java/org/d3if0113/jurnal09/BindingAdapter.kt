package org.d3if0113.jurnal09

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

@BindingAdapter("imageURL")
fun bindImage(imgView: ImageView, imgURL: String?) {
    imgURL?.let {
        val imgUri = Uri.parse(imgURL)
        Glide.with(imgView.context).load(imgUri).into(imgView)
    }
}