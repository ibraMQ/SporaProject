package com.example.corrutinassample.main.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.corrutinassample.R
import com.example.corrutinassample.databinding.ActivityMainBinding
import com.example.corrutinassample.main.data.ItemsProvider
import com.example.corrutinassample.main.presentation.adapters.MainAdapter
import com.example.corrutinassample.main.presentation.viewmodel.MainViewModel
import java.net.CacheResponse

//main
class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mainAdapter = MainAdapter()
    private val observer = { items: List<String> -> mainAdapter.setData(items) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ItemsProvider.startEmitting()
        ItemsProvider.observable.suscribe(observer)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.textViewItemMain.adapter = mainAdapter
    }

    override fun onDestroy() {
        ItemsProvider.observable.unsuscribe(observer)
        super.onDestroy()
    }

}

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActions()
        initObservers()
    }

    private fun initActions(){
        viewModel.requestData()
    }
    private fun initObservers(){
        viewModel.requestData.observe(this, ::handleData)
    }
    private fun handleData(response: String){

    }*/
