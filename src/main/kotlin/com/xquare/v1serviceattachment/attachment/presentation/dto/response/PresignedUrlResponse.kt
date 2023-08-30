package com.xquare.v1serviceattachment.attachment.presentation.dto.response

data class PresignedUrlResponses(
    val presignedUrls: List<PresignedUrlResponse>
)
data class PresignedUrlResponse(
    val url: String,
    val presignedUrl: String,
    val originalFilename: String,
    val contentType: String,
)

