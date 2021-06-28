package com.mtg.colorconverter.extension

import com.google.android.material.textfield.TextInputEditText

/** */
fun TextInputEditText.isComplete(): Boolean {
    return !text.toString().isNullOrBlank()
}