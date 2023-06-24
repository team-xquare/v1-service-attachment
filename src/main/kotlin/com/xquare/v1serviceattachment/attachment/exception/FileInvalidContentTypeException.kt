package com.xquare.v1serviceattachment.attachment.exception

import com.xquare.v1serviceattachment.config.error.AttachmentException
import com.xquare.v1serviceattachment.config.error.ErrorCode

object FileInvalidContentTypeException : AttachmentException(ErrorCode.INVALID_CONTENT_TYPE)
