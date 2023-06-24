package com.xquare.v1serviceattachment.attachment.presentation.dto.response

data class PresignedUrlResponse(
    val url: String,
    val presignedUrl: String,
    val originalFilename: String,
    val contentType: String,
)
