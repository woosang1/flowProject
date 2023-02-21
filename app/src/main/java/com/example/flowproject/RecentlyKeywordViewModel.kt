package com.example.flowproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.db.RecentlyKeywordDao
import com.example.db.RecentlyKeywordData
import com.example.db.RecentlyMovieDao
import com.example.flowproject.databinding.ActivityKeyBinding
import com.example.flowproject.main.MainViewModel
import com.example.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecentlyKeywordViewModel @Inject constructor(
    private val recentlyKeywordDao: RecentlyKeywordDao,
) : ViewModel() {

    fun getAllKeyData(): List<RecentlyKeywordData>{
        return recentlyKeywordDao.selectAll()
    }
}