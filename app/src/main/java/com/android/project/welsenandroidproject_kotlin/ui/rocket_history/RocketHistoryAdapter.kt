package com.android.project.welsenandroidproject_kotlin.ui.rocket_history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.project.domain.entity.history.RocketHistoryEntity
import com.android.project.welsenandroidproject_kotlin.databinding.ItemRocketInfoBinding

class RocketHistoryAdapter (
    private val listener: Listener
) : ListAdapter<RocketHistoryEntity, RocketHistoryAdapter.ViewHolder>(
    ItemDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRocketInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = currentList[position]
        holder.tvName.text = data.name
        holder.tvDate.text = data.first_flight
        holder.tvDescription.text = data.description

        val expandList: MutableList<Int> = mutableListOf()
        var isCollapsed = true

        holder.ivExpand.setOnClickListener {
            if (isCollapsed) {
                holder.tvDescription.visibility = View.VISIBLE
                holder.btnCheckMore.visibility = View.VISIBLE
                isCollapsed = false
            } else {
                holder.tvDescription.visibility = View.GONE
                holder.btnCheckMore.visibility = View.GONE
                isCollapsed = true
            }
        }

        holder.btnCheckMore.setOnClickListener {
            listener.onClick()
        }
    }

    inner class ViewHolder(
        binding: ItemRocketInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val tvName = binding.tvItemRocketInfoName
        val tvDate = binding.tvItemRocketInfoDate
        val tvDescription = binding.tvItemRocketInfoDescription
        val btnCheckMore = binding.btnItemRocketInfoCheckMore
        val ivExpand = binding.ivItemRocketInfoExpand
    }

    interface Listener{
        fun onClick()
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<RocketHistoryEntity>() {
    override fun areItemsTheSame(oldItem: RocketHistoryEntity, newItem: RocketHistoryEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RocketHistoryEntity, newItem: RocketHistoryEntity): Boolean {
        return oldItem == newItem
    }

}