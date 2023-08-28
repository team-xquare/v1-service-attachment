package com.xquare.v1serviceattachment.attachment.common.annotation.constraint

import com.xquare.v1serviceattachment.attachment.common.annotation.FileSizeLimit
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class FileSizeValidator: ConstraintValidator<FileSizeLimit, Int>  {

    private var value = 0
    private var message = ""
    private var byteValue = value

    override fun isValid(fileSize: Int, cxt: ConstraintValidatorContext): Boolean {
        return if (fileSize in 0 .. byteValue ) {
            true
        } else {
            cxt.disableDefaultConstraintViolation()
            cxt.buildConstraintViolationWithTemplate("파일 크기는 ${value}MB 이하이여야 합니다")
                .addConstraintViolation()
            false
        }
    }

    override fun initialize(constraintAnnotation: FileSizeLimit) {
        value = constraintAnnotation.value
        message = constraintAnnotation.message
        byteValue = value * 1024 * 1024
    }

}
