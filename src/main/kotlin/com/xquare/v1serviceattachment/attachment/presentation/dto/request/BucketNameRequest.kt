package com.xquare.v1serviceattachment.attachment.presentation.dto.request

import javax.validation.constraints.NotNull

data class BucketNameRequest (

    @NotNull
    val bucketName: String,
)
