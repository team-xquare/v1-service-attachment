package com.xquare.v1serviceattachment.config.error

import com.fasterxml.jackson.annotation.JsonIgnore

class ErrorResponse(
    @JsonIgnore
    val errorCode: ErrorCode,
    val message: String = errorCode.message,
) {

    fun getStatus(): Int = errorCode.status

}
