package com.netki.sapphire.service

import com.netki.TidKms
import com.netki.model.AttestationCertificate
import com.netki.model.AttestationInformation
import com.netki.sapphire.model.CertificatePayload
import com.netki.sapphire.model.PrivateKeyPayload
import com.netki.sapphire.model.StorageInformation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TidKmsService {

    @Autowired
    private lateinit var tidKms: TidKms

    fun generateCertificates(attestationsInformation: List<AttestationInformation>): List<AttestationCertificate> =
        tidKms.generateCertificates(attestationsInformation)

    fun storeCertificatePem(certificatePem: String) = StorageInformation(tidKms.storeCertificatePem(certificatePem))

    fun storePrivateKeyPem(privateKeyPem: String) = StorageInformation(tidKms.storePrivateKeyPem(privateKeyPem))

    fun fetchCertificatePem(certificateId: String) = CertificatePayload(tidKms.fetchCertificatePem(certificateId))

    fun fetchPrivateKeyPem(privateKeyId: String) = PrivateKeyPayload(tidKms.fetchPrivateKeyPem(privateKeyId))
}
