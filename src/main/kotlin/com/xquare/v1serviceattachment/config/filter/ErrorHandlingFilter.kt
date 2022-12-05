package com.xquare.v1serviceattachment.config.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.v1serviceattachment.config.error.AttachmentException
import com.xquare.v1serviceattachment.config.error.ErrorCode
import com.xquare.v1serviceattachment.config.error.ErrorResponse
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ErrorHandlingFilter(
    val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: AttachmentException) {
            errorToJson(e.errorCode, response)
        } catch (e: Exception) {
            if(e.cause is AttachmentException) {
                errorToJson((e.cause as AttachmentException).errorCode, response)
            } else {
                logger.error("INTERNAL_SERVER_ERROR", e)
                errorToJson(ErrorCode.INTERNAL_SERVER_ERROR, response)
            }
        }
    }

    private fun errorToJson(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.contentType = "application/json"
        response.writer.write(objectMapper.writeValueAsString(ErrorResponse(errorCode)))
    }
}
