package org.d3if0113.jurnal09.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0113.jurnal09.databinding.HomeItemBinding
import org.d3if0113.jurnal09.network.MiwokProperty

class HomeAdapter : ListAdapter<MiwokProperty, HomeAdapter.PropertyMiwokViewHolder>(DiffCallback) {

    class PropertyMiwokViewHolder(private var binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(miwokProperty: MiwokProperty) {
            binding.property = miwokProperty
            binding.backgroundParsedColorDrawable =
                ColorDrawable(Color.parseColor(miwokProperty.background))
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MiwokProperty>() {
        override fun areItemsTheSame(oldItem: MiwokProperty, newItem: MiwokProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MiwokProperty, newItem: MiwokProperty): Boolean {
            return oldItem.category == newItem.category
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeAdapter.PropertyMiwokViewHolder {
        return PropertyMiwokViewHolder(HomeItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HomeAdapter.PropertyMiwokViewHolder, position: Int) {
        val miwokProperty = getItem(position)
        holder.bind(miwokProperty)
    }

}