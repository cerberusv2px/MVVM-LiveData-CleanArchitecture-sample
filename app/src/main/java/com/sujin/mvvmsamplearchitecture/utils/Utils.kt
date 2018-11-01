package com.sujin.mvvmsamplearchitecture.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(inputDate: String, inputFormat: String, outputFormat: String): String {
    val outputDateFormat = SimpleDateFormat(outputFormat, Locale.getDefault())
    val inputDateFormat = SimpleDateFormat(inputFormat, Locale.getDefault())
    val date = inputDateFormat.parse(inputDate)
    return outputDateFormat.format(date)
}
