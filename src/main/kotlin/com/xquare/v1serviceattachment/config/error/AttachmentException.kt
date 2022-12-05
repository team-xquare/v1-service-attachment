package com.xquare.v1serviceattachment.config.error

abstract class AttachmentException(
    val errorCode: ErrorCode
) : RuntimeException() {
    override fun fillInStackTrace() = this
}
