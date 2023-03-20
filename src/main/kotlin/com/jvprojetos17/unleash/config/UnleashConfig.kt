package com.jvprojetos17.unleash.config

import no.finn.unleash.DefaultUnleash
import no.finn.unleash.Unleash
import no.finn.unleash.util.UnleashConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UnleashConfig(
    @Value("\${spring.application.name}") private val appName: String,
    @Value("\${unleash.instance.id}") private val instanceId: String,
    @Value("\${unleash.api.uri}") private val unleashApiUri: String,
    @Value("\${unleash.api.key}") private val unleashApiKey: String,
) {
    private val config = UnleashConfig.builder()
        .appName(appName)
        .instanceId(instanceId)
        .unleashAPI(unleashApiUri)
        .customHttpHeader("Authorization", unleashApiKey)
        .build()

    @Bean
    fun unleash(): Unleash {
        return DefaultUnleash(config)
    }
}
