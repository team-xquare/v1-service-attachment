package com.xquare.v1serviceattachment.attachment.common

enum class FileType(
    val extension: String,
    val contentType: String,
) {
    JPG("jpg", "image/jpg"),
    PNG("png", "image/png"),
    JPEG("jpeg", "image/jpeg"),
    HEIC("heic", "image/heic"),
    WEBP("webp", "image/webp"),
}
