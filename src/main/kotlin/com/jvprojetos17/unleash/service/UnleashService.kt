package com.jvprojetos17.unleash.service

import com.jvprojetos17.unleash.config.UnleashContext
import org.springframework.stereotype.Service

@Service
class UnleashService(
    private val unleashContext: UnleashContext
) {
    fun checkUserEnableById(userId: String): String {
        return if (unleashContext.isUserEnabled(userId)) {
            "Usuário [$userId] está ativo para funcionalidade!"
        } else {
            "Usuário [$userId] está desativado para funcionalidade!"
        }
    }
}
