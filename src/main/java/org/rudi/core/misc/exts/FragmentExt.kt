package org.rudi.core.misc.exts

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
