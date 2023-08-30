package com.xquare.v1serviceattachment.attachment.presentation

import com.xquare.v1serviceattachment.attachment.presentation.dto.request.ImageFileRequests
import com.xquare.v1serviceattachment.attachment.presentation.dto.response.PresignedUrlResponse
import com.xquare.v1serviceattachment.attachment.presentation.dto.response.PresignedUrlResponses
import com.xquare.v1serviceattachment.attachment.service.PresignedUrlServingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/attachment")
class AttachmentController(
    private val imageUploadService: PresignedUrlServingService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun uploadPresigendURL(@RequestBody @Valid files: ImageFileRequests): PresignedUrlResponses {
        return imageUploadService.execute(files.imageFileRequests)
    }
}
