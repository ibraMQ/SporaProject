package com.example.corrutinassample.main.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corrutinassample.main.data.datasourceimplementations.MainUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _requestData = MutableLiveData<String>()
    val requestData: LiveData<String> = _requestData
    val mainUseCaseImpl=MainUseCaseImpl()

    fun requestData(){
        viewModelScope.launch (Dispatchers.IO){
            _requestData.postValue(mainUseCaseImpl.requestData())
        }
    }
}