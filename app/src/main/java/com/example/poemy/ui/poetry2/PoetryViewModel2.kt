package com.example.poemy.ui.poetry2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poemy.network.Poetry2
import com.example.poemy.network.PoetryApi2
import kotlinx.coroutines.launch
import java.lang.Exception

enum class Poetry2ApiStatus { LOADING, ERROR, DONE }

class PoetryViewModel2 : ViewModel() {
    private val _status2 = MutableLiveData<Poetry2ApiStatus>()
    val status2: LiveData<Poetry2ApiStatus> = _status2

    private val _poetry2 = MutableLiveData<List<Poetry2>>()
    val poetry2: LiveData<List<Poetry2>> = _poetry2

    private val _poem2 = MutableLiveData<Poetry2>()
    val poem2: LiveData<Poetry2> = _poem2


    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    fun getPoetryList() {
        viewModelScope.launch {
            _status2.value = Poetry2ApiStatus.LOADING
            try {
                _poetry2.value = PoetryApi2.retrofitServiceApi.getData()
                _status2.value = Poetry2ApiStatus.DONE
            } catch (e: Exception) {
                _poetry2.value = listOf()
                _status2.value = Poetry2ApiStatus.ERROR
            }
        }
    }

    fun onPoetryClicked(poetry2: Poetry2) {
        _poem2.value = poetry2
    }

}