package com.xquare.v1serviceattachment.config.config

import com.xquare.v1serviceattachment.attachment.properties.AwsS3Properties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackageClasses = [AwsS3Properties::class])
@Configuration
class PropertiesScanConfig
