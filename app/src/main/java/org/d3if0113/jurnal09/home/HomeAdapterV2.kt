package org.d3if0113.jurnal09.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0113.jurnal09.databinding.HomeItemBinding
import org.d3if0113.jurnal09.network.MiwokV2

class HomeAdapterV2(val clickListener: HomeListener) :
    ListAdapter<MiwokV2, HomeAdapterV2.PropertyMiwokViewHolder>(DiffCallback) {

    class PropertyMiwokViewHolder(private var binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(miwokV2: MiwokV2, clickListener: HomeListener) {
            binding.propertyV2 = miwokV2
            binding.backgroundParsedColorDrawableV2 =
                ColorDrawable(Color.parseColor(miwokV2.background))
            binding.clickListenerV2 = clickListener
            Log.i("propertyV2", "${miwokV2.category}")
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MiwokV2>() {
        override fun areItemsTheSame(oldItem: MiwokV2, newItem: MiwokV2): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MiwokV2, newItem: MiwokV2): Boolean {
            return oldItem.category == newItem.category
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeAdapterV2.PropertyMiwokViewHolder {
        return PropertyMiwokViewHolder(HomeItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HomeAdapterV2.PropertyMiwokViewHolder, position: Int) {
        val miwokV2 = getItem(position)
        holder.bind(miwokV2, clickListener)
    }

    class HomeListener(val clickListener: (miwokV2: MiwokV2) -> Unit) {
        fun onClick(miwokV2: MiwokV2) = clickListener(miwokV2)
    }

}