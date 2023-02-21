package com.example.flowproject

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.model.rp.RpMovieModel
import com.example.network.NetworkManager
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkManager: NetworkManager
) : ViewModel() {

    fun getData() {
        networkManager.getMovieData(
            query = "여름",
            display = 10
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<RpMovieModel>() {
                override fun onSuccess(t: RpMovieModel) {
                    Log.i("aa" , "t :${t}")
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                    Log.i("aa" , "e :${e}")
                }
            })
    }
}