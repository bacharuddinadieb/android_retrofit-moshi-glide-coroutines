package org.d3if0113.jurnal09.detailwithgambar

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0113.jurnal09.databinding.DetailWithGambarItemBinding
import org.d3if0113.jurnal09.network.WordList

class DetailWithGambarAdapter :
    ListAdapter<WordList, DetailWithGambarAdapter.PropertyMiwokViewHolder>(DiffCallback) {

    class PropertyMiwokViewHolder(private var binding: DetailWithGambarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wordList: WordList) {
            binding.property = wordList
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<WordList>() {
        override fun areItemsTheSame(oldItem: WordList, newItem: WordList): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: WordList, newItem: WordList): Boolean {
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
        val wordList = getItem(position)
        holder.bind(wordList)
        Log.i("holder", "${wordList} holder")

    }

}