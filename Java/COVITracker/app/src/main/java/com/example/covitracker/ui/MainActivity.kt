package com.example.covitracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covitracker.R
import com.example.covitracker.network.data.Country
import com.example.covitracker.ui.adapters.ModelListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mProgressBar: ProgressBar? = null

    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        mProgressBar = progressBar
        progressBar.visibility = View.VISIBLE
        val data = Observer<Country> {
            recyclerView.adapter = ModelListAdapter(it.Countries)
            progressBar.visibility = View.GONE
        }
        viewModel.callApi().observe(this, data)

//        searchButton.setOnClickListener { View }
    }
}
