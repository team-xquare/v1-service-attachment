package com.xquare.v1serviceattachment.attachment.facade

import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

@Component
class AttachmentFacade {

    fun transferFile(): (MultipartFile) -> File {
        val transferFile = { multipartFile: MultipartFile ->
            File("${UUID.randomUUID()}@${multipartFile.originalFilename}").let {
                FileOutputStream(it).run {
                    this.write(multipartFile.bytes)
                    this.close()
                }
                it
            }
        }
        return transferFile
    }
}
