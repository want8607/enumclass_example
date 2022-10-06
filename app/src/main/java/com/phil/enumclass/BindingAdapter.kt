package com.phil.enumclass

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.phil.enumclass.network.Photo

@BindingAdapter("apiStatus","photo")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?, photo: Photo?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusImageView.visibility = View.GONE
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.GONE
        }
        ApiStatus.DONE -> {
            statusImageView.visibility = View.VISIBLE
            photo?.let {
                statusImageView.load(it.imgSrcUrl)
            }
        }
        else->{}
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusTextView: TextView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusTextView.visibility = View.VISIBLE
            statusTextView.text = "로딩중"
        }
        ApiStatus.ERROR -> {
            statusTextView.visibility = View.VISIBLE
            statusTextView.text = "에러"
        }
        ApiStatus.DONE -> {
            statusTextView.visibility = View.GONE
        }
        else->{}
    }
}

