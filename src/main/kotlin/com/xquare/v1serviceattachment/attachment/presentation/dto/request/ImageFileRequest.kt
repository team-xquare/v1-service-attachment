package com.xquare.v1serviceattachment.attachment.presentation.dto.request

import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern

data class FileRequest(

    @Min(1)
    val imageFileRequests: List<@Valid ImageFileRequest>
)

data class ImageFileRequest(
    @field:Pattern(regexp = "^[A-Za-z0-9-_,\\s]+[.]{1}[A-Za-z]{3,4}\$", message = "올바른 파일명이 아닙니다")
    val originalFilename: String,
    @field:Pattern(regexp = "^\\s*([a-z]+)/([a-z0-9\\-+]+)\\s*(?:;(.*))?\$", message = "올바른 Content-Type이 아닙니다")
    val contentType: String,
    @field:Max(10)
    val fileSize: Long,
)
