package com.jvprojetos17.unleash.controller

import com.jvprojetos17.unleash.service.UnleashService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feature-toggle")
class UnleashController(
    private val unleashService: UnleashService,
) {

    @GetMapping("/check-user-enable")
    fun checkUserEnableById(@RequestParam(required = true) userId: String): ResponseEntity<String> {
        return ResponseEntity.ok().body(unleashService.checkUserEnableById(userId))
    }
}
