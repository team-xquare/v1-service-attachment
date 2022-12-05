package com.xquare.v1serviceattachment.attachment.service

import com.xquare.v1serviceattachment.attachment.exception.FileInvalidExtensionException
import com.xquare.v1serviceattachment.thirdparty.s3.AwsS3Util
import org.springframework.stereotype.Service
import java.io.File

@Service
class ImageUploadService(
    private val awsS3Util: AwsS3Util
) {

    fun execute(file: File): String {
        if (!file.isCorrectExtension(file)) {
            file.delete()
            throw FileInvalidExtensionException
        }

        return awsS3Util.upload(file)
    }

    internal fun File.isCorrectExtension(file: File) = when (file.extension.lowercase()) {
        "jpg", "jpeg", "png", "heic" -> true
        else -> false
    }
}
