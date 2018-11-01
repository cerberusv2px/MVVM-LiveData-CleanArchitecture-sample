package com.rosia.delivery.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.TextView

@BindingAdapter(value = ["setVisibilityForPhone"])
fun setVisibility(textView: TextView, item: String?) {
    if (item != null && item.isEmpty()) {
        textView.visibility = View.GONE
    } else {
        textView.visibility = View.VISIBLE
    }
}


