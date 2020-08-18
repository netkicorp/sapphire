package com.netki.sapphire.controller

import com.netki.model.AddressCurrency
import com.netki.sapphire.service.AddressInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/address-info")
class AddressInfoController {

    @Autowired
    private lateinit var addressInfoService: AddressInfoService

    @GetMapping(value = ["/{address_currency}/{address}"])
    fun createInvoiceRequest(
        @PathVariable("address_currency") addressCurrency: AddressCurrency,
        @PathVariable("address") address: String
    ) = ResponseEntity(addressInfoService.getAddressInfo(addressCurrency, address), HttpStatus.OK)
}
