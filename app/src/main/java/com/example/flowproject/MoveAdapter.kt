package com.example.flowproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flowproject.databinding.LayoutMoveItemBinding

class MoveAdapter : RecyclerView.Adapter<MoveViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        return MoveViewHolder(
            binding = LayoutMoveItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return 5
    }
}