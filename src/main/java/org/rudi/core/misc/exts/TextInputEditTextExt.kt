package org.rudi.core.misc.exts

import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.showError(
    @StringRes
    stringId: Int
){
    this.error = this.context.resources.getText(stringId)
    this.isErrorEnabled = true
}

fun TextInputLayout.showError(
    text: String
){
    this.error = text
    this.isErrorEnabled = true
}

fun TextInputLayout.disableError(){
    this.isErrorEnabled = false
}