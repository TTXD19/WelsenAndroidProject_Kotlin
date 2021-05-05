package com.android.project.welsenandroidproject_kotlin.ui.event_history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.project.domain.entity.history.EventHistoryEntity
import com.android.project.welsenandroidproject_kotlin.databinding.ItemEventHistoryBinding

class EventHistoryAdapter(): ListAdapter<EventHistoryEntity, EventHistoryAdapter.ViewHolder>(
    ItemDiffCallbackHistory()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEventHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = currentList[position]

        holder.tvTitle.text = data.title
        holder.tvDescription.text = data.details
        holder.tvYear.text = data.event_date_utc?.substring(0..3)
    }

    inner class ViewHolder(
        binding: ItemEventHistoryBinding
    ): RecyclerView.ViewHolder(binding.root){

        val tvTitle = binding.tvItemEventHistoryTitle
        val tvDescription = binding.tvItemEventHistoryDescription
        val tvYear = binding.tvItemEventHistoryYear

    }
}

class ItemDiffCallbackHistory : DiffUtil.ItemCallback<EventHistoryEntity>() {
    override fun areItemsTheSame(oldItem: EventHistoryEntity, newItem: EventHistoryEntity): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: EventHistoryEntity, newItem: EventHistoryEntity): Boolean {
        return oldItem == newItem
    }

}
