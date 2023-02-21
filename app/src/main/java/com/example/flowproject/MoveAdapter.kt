package com.example.flowproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flowproject.databinding.LayoutMoveItemBinding
import com.example.model.MovieModel

class MoveAdapter(
    private val mainViewModel: MainViewModel
) : RecyclerView.Adapter<MoveViewHolder>() {

    private var modelList = ArrayList<MovieModel.Items>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        return MoveViewHolder(
            context = parent.context,
            binding = LayoutMoveItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            mainViewModel = mainViewModel
        )
    }

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        holder.onBind(modelList[position])
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(items: ArrayList<MovieModel.Items>) {
        modelList.clear()
        modelList.addAll(items)
        notifyDataSetChanged()
    }

}