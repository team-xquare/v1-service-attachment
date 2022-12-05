package com.xquare.v1serviceattachment.config.error

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error."),

    INVALID_ARGUMENT(400, "Invalid Argument"),
}
