package com.xquare.v1serviceattachment.thirdparty.s3

import com.xquare.v1serviceattachment.attachment.presentation.dto.response.PresignedUrlResponse
import org.springframework.stereotype.Component
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import software.amazon.awssdk.services.s3.presigner.S3Presigner
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest
import java.time.Duration

@Component
class AwsS3Util(
    private val s3Presigner: S3Presigner,
) {
    fun getPresignedUrl(originFileName: String, transferredName: String, contentType: String, fileSize: Long, bucketName: String) : PresignedUrlResponse {
        val presignedUrl = getGeneratePreSignedUrlRequest(transferredName, contentType, fileSize, bucketName)

        val resourceUrl = presignedUrl.substring(0, presignedUrl.lastIndexOf('?'))

        return PresignedUrlResponse(
            resourceUrl,
            presignedUrl,
            originFileName,
            contentType,
        )
    }

    private fun getGeneratePreSignedUrlRequest(fileName: String, contentType: String, fileSize: Long, bucketName: String): String {

        val objectRequest = PutObjectRequest.builder()
            .bucket(bucketName)
            .key(fileName)
            .contentType(contentType)
            .contentLength(fileSize)
            .build()

        val presignedRequest = PutObjectPresignRequest.builder()
            .signatureDuration(Duration.ofMinutes(3))
            .putObjectRequest(objectRequest)
            .build()

        return s3Presigner.presignPutObject(presignedRequest).url().toString()
    }
}
