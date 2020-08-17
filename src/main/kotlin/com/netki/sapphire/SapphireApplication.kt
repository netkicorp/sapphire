package com.netki.sapphire

import com.netki.TidAddressInfo
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

    @Value("\${transact-id.address.provider.authorization-key}")
    private lateinit var addressProviderAuthorizationKey: String
    
    @Bean
    fun getTransactId() = TransactId.getInstance(trustStoreLocation, addressProviderAuthorizationKey)

    @Bean
    fun getTidAddressInfo() = TidAddressInfo.getInstance(addressProviderAuthorizationKey)
}

fun main(args: Array<String>) {
    runApplication<SapphireApplication>(*args)
}
