package com.phil.enumclass

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phil.enumclass.network.Photo
import com.phil.enumclass.network.PhotoApi
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class PhotoViewModel : ViewModel() {
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _photo = MutableLiveData<Photo>()
    val photo: LiveData<Photo>
        get() = _photo

    init {
        getPhoto()
    }

    private fun getPhoto() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _photo.value = PhotoApi.retrofitService.getPhoto()
                _status.value = ApiStatus.DONE
            } catch (e: Exception){
                _status.value = ApiStatus.ERROR
            }
        }
    }
}