package com.example.flowproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setRecyclerView()
    }

    private fun setRecyclerView(){
        binding.recyclerView.run {
            adapter = MoveAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        }
    }


}