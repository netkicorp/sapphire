package com.netki.sapphire.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class Bip75Controller {

    @GetMapping(value = ["/welcome"])
    fun welcome(): String {
        return "Welcome controller!!"
    }
}
