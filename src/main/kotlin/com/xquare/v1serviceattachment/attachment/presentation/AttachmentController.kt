package com.xquare.v1serviceattachment.attachment.presentation

import com.xquare.v1serviceattachment.attachment.facade.AttachmentFacade
import com.xquare.v1serviceattachment.attachment.service.ImageUploadService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
@RequestMapping("/attachment")
class AttachmentController(
    private val imageUploadService: ImageUploadService,
    private val attachmentFacade: AttachmentFacade
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun imageUpload(file: MultipartFile) {
        imageUploadService.execute(file.let(attachmentFacade.transferFile()))
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("lists")
    fun uploadMultipleImage(files: List<MultipartFile>) {
        imageUploadService.execute(files.map(attachmentFacade.transferFile()))
    }
}
