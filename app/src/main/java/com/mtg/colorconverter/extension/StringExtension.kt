package com.mtg.colorconverter.extension

import java.text.SimpleDateFormat
import java.util.*

/** */
fun String.toLocalDateFormat(): String {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val localFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val originalDate = format.parse(this)
    return localFormat.format(originalDate)
}