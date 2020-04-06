package org.d3if0113.jurnal09.detailwithgambar

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0113.jurnal09.databinding.DetailWithGambarItemBinding
import org.d3if0113.jurnal09.network.MiwokV2

class DetailWithGambarAdapter :
    ListAdapter<MiwokV2, DetailWithGambarAdapter.PropertyMiwokViewHolder>(DiffCallback) {

    class PropertyMiwokViewHolder(private var binding: DetailWithGambarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(miwokV2: MiwokV2) {
            binding.property = miwokV2
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MiwokV2>() {
        override fun areItemsTheSame(oldItem: MiwokV2, newItem: MiwokV2): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MiwokV2, newItem: MiwokV2): Boolean {
            return oldItem.defaultWord == newItem.defaultWord
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailWithGambarAdapter.PropertyMiwokViewHolder {
        return PropertyMiwokViewHolder(
            DetailWithGambarItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(
        holder: DetailWithGambarAdapter.PropertyMiwokViewHolder,
        position: Int
    ) {
        val miwokV2 = getItem(position)
        holder.bind(miwokV2)
        Log.i("holder", "${miwokV2} holder")

    }

}