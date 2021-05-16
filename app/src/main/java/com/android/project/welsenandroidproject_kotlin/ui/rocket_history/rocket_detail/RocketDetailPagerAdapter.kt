package com.android.project.welsenandroidproject_kotlin.ui.rocket_history.rocket_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.project.welsenandroidproject_kotlin.databinding.ItemRocketDetailPagerBinding
import com.bumptech.glide.Glide

class RocketDetailPagerAdapter :
    ListAdapter<String, RocketDetailPagerAdapter.RocketDetailPagerViewHolder>(
        DiffCallBack
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketDetailPagerViewHolder {
        return RocketDetailPagerViewHolder(
            ItemRocketDetailPagerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RocketDetailPagerViewHolder, position: Int) {
        val data = currentList[position]
        Glide.with(holder.ivImage)
            .load(data)
            .into(holder.ivImage)
    }

    inner class RocketDetailPagerViewHolder(binding: ItemRocketDetailPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val ivImage = binding.ivImage
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}