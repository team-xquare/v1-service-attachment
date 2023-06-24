package com.xquare.v1serviceattachment.thirdparty.s3.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConfigurationProperties("cloud.aws.credentials")
@ConstructorBinding
data class S3Property(
    val accessKey: String,
    val secretKey: String,
)
