package com.xquare.v1serviceattachment.thirdparty.s3.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.internal.signing.DefaultS3Presigner
import software.amazon.awssdk.services.s3.presigner.S3Presigner

@Configuration
class S3Configuration(
    val s3Property: S3Property,
) {
    @Bean
    fun getS3Presigner(): S3Presigner {
        return DefaultS3Presigner.builder()
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(
                        s3Property.accessKey,
                        s3Property.secretKey,
                    ),
                ),
            )
            .region(Region.AP_NORTHEAST_2)
            .build()
    }
}
