package com.xquare.v1serviceattachment.attachment.exception

import com.xquare.v1serviceattachment.config.error.AttachmentException
import com.xquare.v1serviceattachment.config.error.ErrorCode

object FileInvalidExtensionException : AttachmentException(ErrorCode.INVALID_EXTENSION)
