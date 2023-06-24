object Dependencies {
    // ktlint
    const val KTLINT = "com.pinterest:ktlint:${DependencyVersions.KTLINT_VERSION}"

    // web
    const val SPRING_WEB = "org.springframework.boot:spring-boot-starter-web"

    // validation
    const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // kotlin
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    // cloud
    const val SPRING_CLOUD = "org.springframework.cloud:spring-cloud-dependencies:${DependencyVersions.SPRING_CLOUD_VERSION}"

    // sentry
    const val SENTRY = "io.sentry:sentry-spring-boot-starter:${DependencyVersions.SENTRY_VERSION}"

    // aws
    const val AWS_S3 = "software.amazon.awssdk:s3"
    const val AWS_S3_PLATFORM = "software.amazon.awssdk:bom:${DependencyVersions.AWS_S3}"

    // cloud config
    const val CLOUD_CONFIG = "org.springframework.cloud:spring-cloud-config-client"
}
