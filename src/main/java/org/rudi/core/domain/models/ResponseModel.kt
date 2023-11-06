package org.rudi.core.domain.models

data class ResponseModel<MODEL: Any>(
    val type: ResponseType,
    val info: MODEL?,
    val error: Exception?
){
    enum class ResponseType{
        SUCCESS, ERROR
    }
}
