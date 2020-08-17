package com.netki.sapphire.service

import com.netki.TidAddressInfo
import com.netki.model.AddressCurrency
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressInfoService {

    @Autowired
    private lateinit var tidAddressInfo: TidAddressInfo

    fun getAddressInfo(addressCurrency: AddressCurrency, address: String) =
        tidAddressInfo.getAddressInformation(addressCurrency, address)
}

