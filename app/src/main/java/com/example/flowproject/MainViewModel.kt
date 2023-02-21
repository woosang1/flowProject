package com.example.flowproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.MovieModel
import com.example.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {

    // Movie Data
    private val _movieModelLiveData = MutableLiveData<MovieModel>()
    val movieModelLiveData: LiveData<MovieModel?> = _movieModelLiveData

    // 토스트 노출
    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String> = _showToast

    // 토스트 노출
    private val _goToWebView = MutableLiveData<String>()
    val goToWebView: LiveData<String> = _goToWebView

    fun getData(
        query: String, display: Int
    ) {
        movieUseCase.getMovie(query = query,
            display = display,
            success = {
                _movieModelLiveData.postValue(it)
            },
            fail = {
                _showToast.postValue(it)
            }
        )
    }

    fun goToWebView(url: String){
        _goToWebView.postValue(url)
    }


}