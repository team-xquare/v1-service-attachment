package com.xquare.v1serviceattachment.config.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.v1serviceattachment.config.error.AttachmentException
import com.xquare.v1serviceattachment.config.error.ErrorCode
import com.xquare.v1serviceattachment.config.error.ErrorResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ErrorHandlingFilter(
    private val objectMapper: ObjectMapper
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
            if (e.cause is AttachmentException) {
                errorToJson((e.cause as AttachmentException).errorCode, response)
            } else {
                errorToJson(ErrorCode.INTERNAL_SERVER_ERROR, response)
                e.printStackTrace()
            }
        }
    }

    private fun errorToJson(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(ErrorResponse(errorCode)))
    }
}
