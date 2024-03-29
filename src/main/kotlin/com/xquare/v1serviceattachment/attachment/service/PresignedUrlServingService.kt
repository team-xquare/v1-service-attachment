package com.xquare.v1serviceattachment.attachment.service

import com.xquare.v1serviceattachment.attachment.common.FileType
import com.xquare.v1serviceattachment.attachment.exception.InvalidFileTypeException
import com.xquare.v1serviceattachment.attachment.presentation.dto.request.ImageFileRequest
import com.xquare.v1serviceattachment.attachment.presentation.dto.response.PresignedUrlResponses
import com.xquare.v1serviceattachment.thirdparty.s3.AwsS3Util
import com.xquare.v1serviceattachment.thirdparty.s3.config.S3Property
import org.springframework.stereotype.Service
import java.util.*

@Service
class PresignedUrlServingService(
    private val awsS3Util: AwsS3Util,
    val s3Property: S3Property,
) {

    fun execute(files: List<ImageFileRequest>): PresignedUrlResponses {
        val presignedUrls = files.map { it ->

            val originalName: String = it.originalFilename

            val extension: String = originalName.let { originalName.substringAfterLast(".").lowercase() }
            val contentType: String = it.contentType

            if (checkFileType(extension, contentType)) throw InvalidFileTypeException

            awsS3Util.getPresignedUrl(
                originalName,
                transferFile(originalName),
                contentType,
                it.fileSize,
                s3Property.bucketName,
            )
        }

        return PresignedUrlResponses(presignedUrls)
    }

    private fun checkFileType(extension: String, contentType: String): Boolean = FileType.values().none {
        it.extension == extension && it.contentType == contentType
    }

    private fun transferFile(originalFilename: String): String = "${UUID.randomUUID()}@$originalFilename"
}
