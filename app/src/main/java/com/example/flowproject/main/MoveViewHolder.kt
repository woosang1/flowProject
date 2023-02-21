package com.example.flowproject.main

import android.content.Context
import android.widget.TextView
import androidx.databinding.BindingAdapter
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
            title = "제목 : ${item.title}"
            subTitle = "부제 : ${item.subtitle}"
            star = "평점 : ${item.userRating.toString()}"
            imageView.imageLoad(context = context, item.image)
            rootLayout.setOnClickListener {
                mainViewModel.goToWebView(item.link)
            }
            executePendingBindings()
        }
    }
}

@BindingAdapter("setText")
fun setText(textView: TextView, title : String) {
    textView.text = title
}