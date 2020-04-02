package org.d3if0113.jurnal09.detailwithoutgambar

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0113.jurnal09.databinding.DetailWithoutGambarItemBinding
import org.d3if0113.jurnal09.network.WordList

class DetailWithoutGambarAdapter :
    ListAdapter<WordList, DetailWithoutGambarAdapter.PropertyMiwokViewHolder>(DiffCallback) {

    class PropertyMiwokViewHolder(private var binding: DetailWithoutGambarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wordList: WordList) {
            binding.property = wordList
            Log.i("adapter", wordList.defaultWord)
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
    ): DetailWithoutGambarAdapter.PropertyMiwokViewHolder {
        return PropertyMiwokViewHolder(
            DetailWithoutGambarItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(
        holder: DetailWithoutGambarAdapter.PropertyMiwokViewHolder,
        position: Int
    ) {
        val wordList = getItem(position)
        holder.bind(wordList)
        Log.i("holder", "${wordList} holder")
    }

}