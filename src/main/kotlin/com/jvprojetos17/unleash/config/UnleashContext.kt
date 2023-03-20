package com.jvprojetos17.unleash.config

import no.finn.unleash.Unleash
import no.finn.unleash.UnleashContext
import org.springframework.stereotype.Component

private const val IS_USER_ENABLED_TOGGLE = "user_enable_by_id"

@Component
class UnleashContext(
    private val unleash: Unleash,
) {
    fun isUserEnabled(userId: String): Boolean {
        val context = UnleashContext.builder()
            .userId(userId)
            .environment("development")
            .build()
        return unleash.isEnabled(IS_USER_ENABLED_TOGGLE, context, false)
    }
}
