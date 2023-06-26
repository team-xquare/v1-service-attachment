package com.xquare.v1serviceattachment.attachment.presentation

import com.xquare.v1serviceattachment.attachment.presentation.dto.request.ImageFileRequest
import com.xquare.v1serviceattachment.attachment.presentation.dto.response.PresignedUrlResponse
import com.xquare.v1serviceattachment.attachment.service.PresignedUrlServingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/attachment")
class AttachmentController(
    private val imageUploadService: PresignedUrlServingService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    fun uploadPresigendURL(@RequestBody files: List<ImageFileRequest>, @RequestParam("bucketName") bucketName: String): List<PresignedUrlResponse> {
        return imageUploadService.execute(files, bucketName)
    }
}
