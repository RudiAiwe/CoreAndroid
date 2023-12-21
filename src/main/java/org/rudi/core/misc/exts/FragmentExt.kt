package org.rudi.core.misc.exts

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun Fragment.repeatWhenStarted(action: (suspend () -> Unit)) {
    lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(
            Lifecycle.State.STARTED
        ) {
            action.invoke()
        }
    }
}

fun Fragment.showToast(
    @StringRes
    stringId: Int
){
    Toast.makeText(
        this.requireContext(),
        stringId,
        Toast.LENGTH_LONG
    ).show()
}

fun Fragment.showToast(
    string: String
){
    Toast.makeText(
        this.requireContext(),
        string,
        Toast.LENGTH_LONG
    ).show()
}