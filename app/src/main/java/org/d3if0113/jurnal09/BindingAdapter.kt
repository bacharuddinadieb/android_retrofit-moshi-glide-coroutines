package org.d3if0113.jurnal09

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if0113.jurnal09.detailwithgambar.DetailWithGambarAdapter
import org.d3if0113.jurnal09.detailwithoutgambar.DetailWithoutGambarAdapter
import org.d3if0113.jurnal09.home.HomeAdapter
import org.d3if0113.jurnal09.home.HomeAdapterV2
import org.d3if0113.jurnal09.network.MiwokProperty
import org.d3if0113.jurnal09.network.MiwokV2

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MiwokProperty>?) {
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataV2")
fun bindRecyclerViewV2(recyclerView: RecyclerView, data: List<MiwokV2>?) {
    val adapter = recyclerView.adapter as HomeAdapterV2
    adapter.submitList(data)
}

//@BindingAdapter("listDataWithoutGambar")
//fun bindRecyclerView2(recyclerView: RecyclerView, data: List<WordList>?) {
//    val adapter = recyclerView.adapter as DetailWithoutGambarAdapter
//    adapter.submitList(data)
//}

@BindingAdapter("listDataWithoutGambarV2")
fun bindRecyclerViewV22(recyclerView: RecyclerView, data: List<MiwokV2>?) {
    val adapter = recyclerView.adapter as DetailWithoutGambarAdapter
    adapter.submitList(data)
}

//@BindingAdapter("listDataWithGambar")
//fun bindRecyclerView3(recyclerView: RecyclerView, data: List<WordList>?) {
//    val adapter = recyclerView.adapter as DetailWithGambarAdapter
//    adapter.submitList(data)
//    Log.i("binding adapter", "${data?.size} data")
//}

@BindingAdapter("listDataWithGambarV2")
fun bindRecyclerViewV23(recyclerView: RecyclerView, data: List<MiwokV2>?) {
    val adapter = recyclerView.adapter as DetailWithGambarAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageURL")
fun bindImage(imgView: ImageView, imgURL: String?) {
    imgURL?.let {
        val imgUri = Uri.parse(imgURL)
        Glide.with(imgView.context)
            .load(imgUri)
            .placeholder(R.drawable.gambar_loading)
            .error(R.drawable.ic_broken_image_24dp)
            .into(imgView)
    }
}