package com.xquare.v1serviceattachment

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class V1ServiceAttachmentApplication

fun main(args: Array<String>) {
    runApplication<V1ServiceAttachmentApplication>(*args)
}
