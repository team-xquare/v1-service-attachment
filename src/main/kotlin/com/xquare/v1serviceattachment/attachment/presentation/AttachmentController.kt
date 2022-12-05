package com.xquare.v1serviceattachment.attachment.presentation

import com.xquare.v1serviceattachment.attachment.service.ImageUploadService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping("/attachment")
class AttachmentController(
    private val imageUploadService: ImageUploadService
) {

    @PostMapping
    fun imageUpload(file: File) {
        imageUploadService.execute(file)
    }
}
