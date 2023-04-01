package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "MVVM RecyclerView"

        initRecycler()
        initMainViewModel()
    }

    private fun initRecycler() {
        binding.recView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter()
        binding.recView.adapter = adapter
    }

    private fun initMainViewModel() {
        val viewModel = ViewModelProvider(this)[ActivityMainViewModel::class.java]
        viewModel.getLiveObserverData().observe(this, Observer {
            if (it != null) {
                adapter.setDataList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error to getting List of Data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApi()
    }
}