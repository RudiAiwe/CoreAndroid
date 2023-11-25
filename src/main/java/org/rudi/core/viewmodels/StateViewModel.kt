package org.rudi.core.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class StateViewModel<
        EVENT : ViewModelEvent,
        ACTION : ViewModelAction,
        STATE : ViewModelState
        >:ViewModel() {

    protected val _stateFlow: MutableStateFlow<STATE?> = MutableStateFlow(null)

    val stateFlow:StateFlow<STATE?>
        get() = _stateFlow

    protected val _actionFlow:MutableSharedFlow<ACTION> = MutableSharedFlow()

    val actionFlow: SharedFlow<ACTION>
        get() = _actionFlow

    abstract fun obtainEvent(event: EVENT)

    protected fun sendAction(action: ACTION){
        viewModelScope.launch {
            _actionFlow.emit(action)
        }
    }

    protected fun startWorkInIoContext(work: suspend () -> Unit){
        startWorkInViewModelScope {
            withContext(Dispatchers.IO){
                work.invoke()
            }
        }
    }

    protected fun startWorkInViewModelScope(work: suspend ()->Unit):Job{
        return viewModelScope.launch {
            work.invoke()
        }
    }

    protected fun setState(state: STATE){
        startWorkInViewModelScope {
            _stateFlow.emit(state)
        }
    }
}

interface ViewModelEvent
interface ViewModelAction
interface ViewModelState