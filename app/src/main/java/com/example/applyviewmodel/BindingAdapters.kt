package com.example.applyviewmodel

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgree(progressBar: ProgressBar, counter: Int, max: Int) {
    progressBar.progress = (counter * 2).coerceAtMost(max)
}

