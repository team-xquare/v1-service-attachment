package com.xquare.v1serviceattachment.attachment.service

import com.xquare.v1serviceattachment.attachment.exception.FileInvalidExtensionException
import com.xquare.v1serviceattachment.attachment.presentation.dto.response.UploadFileResponse
import com.xquare.v1serviceattachment.thirdparty.s3.AwsS3Util
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

@Service
class ImageUploadService(
    private val awsS3Util: AwsS3Util
) {

    fun execute(files: List<MultipartFile>, bucketName: String): UploadFileResponse {
        val transferred = files.map(transferFile)

        files.forEach { it ->
            val originalName: String? = it.originalFilename
            val extension: String? = originalName?.let { originalName.substring(it.lastIndexOf(".")).lowercase() }

            if (!(extension == ".jpg" || extension == ".jpeg" || extension == ".png" || extension == ".heic" || extension == ".webp")) {
                transferred.deleteAll()
                throw FileInvalidExtensionException
            }
        }

        val imageUrl = awsS3Util.upload(transferred, bucketName)
        return UploadFileResponse(imageUrl)
    }

    private fun List<File>.deleteAll() =
        this.forEach(File::delete)

    private val transferFile = { multipartFile: MultipartFile ->
        val uniqueFilename = "${UUID.randomUUID()}@${multipartFile.originalFilename}"
        val file = File(uniqueFilename)

        FileOutputStream(file).use { outputStream ->
            outputStream.write(multipartFile.bytes)
        }

        file
    }
}
