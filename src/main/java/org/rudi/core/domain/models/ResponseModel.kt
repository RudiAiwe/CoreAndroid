package org.rudi.core.domain.models

data class ResponseModel<MODEL: Any>(
    val type: ResponseType,
    val info: MODEL? = null,
    val error: Exception? = null
){
    enum class ResponseType{
        SUCCESS, ERROR, LOADING
    }
}
