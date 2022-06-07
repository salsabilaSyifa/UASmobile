package com.example.poemy.ui.poetry1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poemy.network.Poetry1
import com.example.poemy.network.Poetry1Api
import kotlinx.coroutines.launch
import java.lang.Exception

enum class Poetry1ApiStatus { LOADING, ERROR, DONE }

class PoetryViewModel1 : ViewModel() {
    private val _status = MutableLiveData<Poetry1ApiStatus>()
    val status: LiveData<Poetry1ApiStatus> = _status

    private val _poetry1 = MutableLiveData<List<Poetry1>>()
    val poetry1: LiveData<List<Poetry1>> = _poetry1

    private val _poem1 = MutableLiveData<Poetry1>()
    val poem1: LiveData<Poetry1> = _poem1


    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    fun getPoetry1List() {
        viewModelScope.launch {
            _status.value = Poetry1ApiStatus.LOADING
            try {
                _poetry1.value = Poetry1Api.retrofitServiceApi.getData()
                _status.value = Poetry1ApiStatus.DONE
            } catch (e: Exception) {
                _poetry1.value = listOf()
                _status.value = Poetry1ApiStatus.ERROR
            }
        }
    }

    fun onPoetry1Clicked(poetry1: Poetry1) {
        _poem1.value = poetry1
    }


}