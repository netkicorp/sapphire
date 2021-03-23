package com.netki.sapphire

import com.netki.TidAddressInfo
import com.netki.TidKms
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

    @Value("\${transact-id.key-management.provider.authorization-key}")
    private lateinit var keyManagementAuthorizationKey: String

    @Value("\${transact-id.key-management.provider.url}")
    private lateinit var keyManagementUrl: String

    @Value("\${transact-id.key-management.storage.authorization-key}")
    private lateinit var keyManagementStorageAuthorizationKey: String

    @Value("\${transact-id.key-management.storage.address}")
    private lateinit var keyManagementStorageAddress: String

    @Bean
    fun getTransactId() = TransactId.getInstance(trustStoreLocation, addressProviderAuthorizationKey, true)

    @Bean
    fun getTidAddressInfo() = TidAddressInfo.getInstance(addressProviderAuthorizationKey)

    @Bean
    fun getTidKms() = TidKms.getInstance(
        keyManagementAuthorizationKey,
        keyManagementStorageAuthorizationKey,
        keyManagementStorageAddress,
        keyManagementUrl
    )
}

fun main(args: Array<String>) {
    runApplication<SapphireApplication>(*args)
}
