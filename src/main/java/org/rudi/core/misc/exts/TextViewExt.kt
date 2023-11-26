package org.rudi.core.misc.exts

import android.graphics.Typeface
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

fun TextView.setBold(
) {
    setTypeface(typeface, Typeface.BOLD)
}

fun TextView.setNormal(){
    setTypeface(typeface, Typeface.NORMAL)
}