package com.example.flowproject

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.extension.imageLoad
import com.example.flowproject.databinding.LayoutMoveItemBinding
import com.example.model.MovieModel


class MoveViewHolder(
    private val context: Context,
    private val binding: LayoutMoveItemBinding,
    private val mainViewModel: MainViewModel
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: MovieModel.Items){
        with(binding){
            imageView.imageLoad(context = context, item.image)
            title.text = "제목 : ${item.title}"
            year.text = "서브타이틀 : ${item.subtitle}"
            star.text = "평점 : ${item.userRating}"
            rootLayout.setOnClickListener {
                mainViewModel.goToWebView(item.link)
            }
        }
    }
}