package com.netki.sapphire

import com.netki.TransactId
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.netki.sapphire"])
class SapphireApplication {

    @Value("\${transact-id.truststore.location}")
    private lateinit var trustStoreLocation: String

    @Bean
    fun getTransactId() = TransactId.getInstance(trustStoreLocation)
}

fun main(args: Array<String>) {
    runApplication<SapphireApplication>(*args)
}
