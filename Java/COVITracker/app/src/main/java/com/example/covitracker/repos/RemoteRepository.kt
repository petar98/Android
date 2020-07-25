package com.example.covitracker.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.covitracker.network.data.Country
import com.example.covitracker.ui.interfaces.RetrofitApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    fun callApi(): MutableLiveData<Country> {
        val mutableLiveData = MutableLiveData<Country>()

        RetrofitApiService().fetchData()
            .enqueue(object : Callback<Country> {
                override fun onFailure(call: Call<Country>?, t: Throwable?) {
                    Log.d("error", "could not get data")
                }

                override fun onResponse(call: Call<Country>?, response: Response<Country>?) {
                    if (response != null) {
                        if (response.isSuccessful) {
                            mutableLiveData.postValue(response.body())
                        } else {
                            Log.d("error", "could not get data")
                        }
                    }
                }
            })
        return mutableLiveData
    }
}