package com.xquare.v1serviceattachment.config.exception

import com.xquare.v1serviceattachment.config.error.AttachmentException
import com.xquare.v1serviceattachment.config.error.ErrorCode

object InvalidServerException : AttachmentException(ErrorCode.INTERNAL_SERVER_ERROR)