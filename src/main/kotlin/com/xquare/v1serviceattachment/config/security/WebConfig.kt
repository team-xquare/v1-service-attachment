package com.xquare.v1serviceattachment.config.security

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowedOrigins(
                "https://prod-server.xquare.app/",
                "https://stag-server.xquare.app/",
                "https://service.xquare.app/",
                "https://admin.xquare.app",
                "https://admin.dsm-pick.com",
                "https://teacher.dsm-pick.com",
                "https://keeper.dsm-pick.com",
                "https://admin.dsm-repo.com",
                "https://user.dsm-repo.com",
                "https://www.dsm-repo.com",
                "http://localhost:3000",
                "http://localhost:3001"
            )
    }
}
