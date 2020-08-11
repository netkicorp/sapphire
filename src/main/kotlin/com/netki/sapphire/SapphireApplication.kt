package com.netki.sapphire

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.netki.sapphire"])
class SapphireApplication

fun main(args: Array<String>) {
	runApplication<SapphireApplication>(*args)
}
