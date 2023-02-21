package com.example.flowproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.extension.dpToPixel
import com.example.flowproject.databinding.ActivityKeyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentlyKeywordActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            Intent(
                context, RecentlyKeywordActivity::class.java
            ).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.let { intent ->
                context.startActivity(intent)
            }
        }
    }

    private lateinit var binding: ActivityKeyBinding
    private val recentlyKeywordViewModel: RecentlyKeywordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()
    }

    private fun setView(){
        val keyList = recentlyKeywordViewModel.getAllKeyData()
        binding.rootLayout.removeAllViews()
        keyList.forEachIndexed { index, recentlyKeywordData ->
            val textView = TextView(this@RecentlyKeywordActivity).apply {
                text = recentlyKeywordData.keyWord
                textSize = 16.dpToPixel().toFloat()
            }
            binding.rootLayout.addView(textView)
        }
    }

}