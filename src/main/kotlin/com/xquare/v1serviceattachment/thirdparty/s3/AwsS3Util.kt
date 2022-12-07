package com.xquare.v1serviceattachment.thirdparty.s3

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.internal.Mimetypes
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.xquare.v1serviceattachment.attachment.exception.FileIOInterruptedException
import com.xquare.v1serviceattachment.attachment.properties.AwsS3Properties
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException

@Component
class AwsS3Util(
    private val awsS3Properties: AwsS3Properties,
    private val amazonS3Client: AmazonS3Client
) {

    fun upload(files: List<File>, bucketName: String): List<String> {
        return files.map {
            inputS3(it, bucketName)
            getResource(it.name, bucketName)
        }
    }

    private fun inputS3(file: File, bucketName: String) {
        try {
            val inputStream = file.inputStream()
            val objectMetadata = ObjectMetadata().apply {
                this.contentLength = file.length()
                this.contentType = Mimetypes.getInstance().getMimetype(file)
            }

            amazonS3Client.putObject(
                PutObjectRequest(bucketName, file.name, inputStream, objectMetadata)
                    .withCannedAcl(
                        CannedAccessControlList.PublicRead
                    )
            )

            file.delete()
        } catch (e: IOException) {
            throw FileIOInterruptedException
        }
    }

    private fun getResource(fileName: String, bucketName: String): String {
        return amazonS3Client.getResourceUrl(bucketName, fileName)
    }
}
