package com.xquare.v1serviceattachment.attachment.presentation.dto.request

import javax.validation.constraints.NotNull

class BucketNameRequest {

    @NotNull
    lateinit var bucketName: String
        private set
}