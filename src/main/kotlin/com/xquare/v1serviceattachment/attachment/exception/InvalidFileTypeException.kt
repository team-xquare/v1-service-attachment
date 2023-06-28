package com.xquare.v1serviceattachment.attachment.exception

import com.xquare.v1serviceattachment.config.error.AttachmentException
import com.xquare.v1serviceattachment.config.error.ErrorCode

object InvalidFileTypeException : AttachmentException(ErrorCode.INVALID_FILE_TYPE)

