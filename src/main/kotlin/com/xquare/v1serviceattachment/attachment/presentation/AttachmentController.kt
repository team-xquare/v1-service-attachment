package com.xquare.v1serviceattachment.attachment.presentation

import com.xquare.v1serviceattachment.attachment.presentation.dto.request.BucketNameRequest
import com.xquare.v1serviceattachment.attachment.presentation.dto.response.UploadFileResponse
import com.xquare.v1serviceattachment.attachment.service.ImageUploadService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/attachment")
class AttachmentController(
    private val imageUploadService: ImageUploadService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun uploadMultipleImage(@RequestPart files: List<MultipartFile>, @RequestPart("bucketName") request: BucketNameRequest): UploadFileResponse {
        return imageUploadService.execute(files, request.bucketName)
    }
}
