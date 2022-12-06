package com.xquare.v1serviceattachment.attachment.service

import com.xquare.v1serviceattachment.attachment.exception.FileInvalidExtensionException
import com.xquare.v1serviceattachment.thirdparty.s3.AwsS3Util
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.util.*

@Service
class ImageUploadService(
    private val awsS3Util: AwsS3Util
) {

    fun execute(files: List<MultipartFile>): List<String> {
        val transfered = files.map(transferFile)

        files.forEach {
            if (!isCorrectExtension(transfered)) {
                transfered.deleteAll()
                throw FileInvalidExtensionException
            }
        }

        return awsS3Util.upload(transfered)
    }

    private fun isCorrectExtension(file: List<File>) = when (file.extension) {
        "jpg", "jpeg", "png", "heic", "webp" -> true
        else -> false
    }

    private fun List<File>.deleteAll() =
        this.forEach(File::delete)

    private val transferFile = { multipartFile: MultipartFile ->
        File("${UUID.randomUUID()}@${multipartFile.originalFilename}").let {
            FileOutputStream(it).run {
                this.write(multipartFile.bytes)
                this.close()
            }
            it
        }
    }
}
