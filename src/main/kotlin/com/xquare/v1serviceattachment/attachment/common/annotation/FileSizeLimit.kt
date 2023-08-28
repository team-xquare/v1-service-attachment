package com.xquare.v1serviceattachment.attachment.common.annotation

import com.xquare.v1serviceattachment.attachment.common.annotation.constraint.FileSizeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [FileSizeValidator::class])
annotation class FileSizeLimit(
    val message: String = "",
    val value: Int = 0,
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
