package org.rudi.core.misc.exts

import android.view.View

fun View.setGone(){
    this.visibility = View.GONE
}
fun View.setVisible(){
    this.visibility = View.VISIBLE
}
fun View.setUnVisible() {
    this.visibility = View.INVISIBLE
}