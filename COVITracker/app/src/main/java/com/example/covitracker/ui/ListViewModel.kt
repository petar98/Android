package com.example.covitracker.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covitracker.network.data.Country
import com.example.covitracker.repos.RemoteRepository

class ListViewModel : ViewModel() {

    fun callApi() : MutableLiveData<Country> {
        return RemoteRepository().callApi();
    }
}