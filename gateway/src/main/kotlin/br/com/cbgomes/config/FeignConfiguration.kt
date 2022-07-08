package br.com.cbgomes.config

import feign.okhttp.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfiguration {
    @Bean
    fun client() = OkHttpClient()
}
