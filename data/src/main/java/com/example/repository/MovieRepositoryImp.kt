package com.example.repository

import android.util.Log
import com.example.model.MovieModel
import com.example.model.rp.RpMovieModel
import com.example.network.NetworkManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val networkManager: NetworkManager
) : MovieRepository {

    override fun getMovie(
        query : String,
        display : Int,
        success: (MovieModel) -> Unit,
        fail: (String) -> Unit) {
        networkManager.getMovieData(
            query = query,
            display = display
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<RpMovieModel>() {
                override fun onSuccess(result: RpMovieModel) {
                    Log.i("aa","result : ${result}")
                    success.invoke(result.mapper())
                }

                override fun onError(e: Throwable) {
                    e.message?.let {
                        fail.invoke(it)
                    }
                }
            })
    }

}