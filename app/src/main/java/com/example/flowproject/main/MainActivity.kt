package com.example.flowproject.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowproject.RecentlyKeywordActivity
import com.example.flowproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        observe()
        setData()
        setClickEvent()
    }

    private fun observe() {
        binding.lifecycleOwner = this@MainActivity
        with(mainViewModel) {
            movieModelLiveData.observe(this@MainActivity, Observer {
                it?.items?.let { items ->
                    mainViewModel.run {
                        insertKeyFromDB(binding.editText.text.toString())
                        items.forEachIndexed { index, item ->
                            insertMovieFromDB(item)
                        }
                    }
                    (binding.recyclerView.adapter as MoveAdapter).addData(items)
                }
            })

            showToast.observe(this@MainActivity, Observer {
                val myToast = Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT)
                myToast.show()
            })

            goToWebView.observe(this@MainActivity, Observer {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(intent)
            })
        }
    }

    private fun setRecyclerView() {
        binding.recyclerView.run {
            adapter = MoveAdapter(mainViewModel)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setClickEvent(){
        with(binding){
            recentlyKeyBtn.setOnClickListener {
                RecentlyKeywordActivity.start(this@MainActivity)
            }

            searchBtn.setOnClickListener {
                setData()
            }
        }
    }
    private fun setData() {
        if (binding.editText.text.toString().isNotEmpty()){
            mainViewModel.getData(
                query = binding.editText.text.toString(),
                display = 10
            )
        }
    }

}