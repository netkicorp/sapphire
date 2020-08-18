package com.netki.sapphire.controller

import com.netki.model.AttestationInformation
import com.netki.sapphire.model.CertificatePayload
import com.netki.sapphire.model.PrivateKeyPayload
import com.netki.sapphire.service.TidKmsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/key-management")
class TidKmsController {

    @Autowired
    private lateinit var tidKmsService: TidKmsService

    @PostMapping(value = ["/certificates"])
    fun generateCertificates(
        @RequestBody attestationsInformation: List<AttestationInformation>
    ) = ResponseEntity(tidKmsService.generateCertificates(attestationsInformation), HttpStatus.CREATED)

    @PostMapping(value = ["/certificate"])
    fun storeCertificate(
        @RequestBody certificatePayload: CertificatePayload
    ) = ResponseEntity(tidKmsService.storeCertificatePem(certificatePayload.certificatePem), HttpStatus.CREATED)

    @PostMapping(value = ["/private-key"])
    fun storePrivateKey(
        @RequestBody privateKeyPayload: PrivateKeyPayload
    ) = ResponseEntity(tidKmsService.storePrivateKeyPem(privateKeyPayload.privateKeyPem), HttpStatus.CREATED)

    @GetMapping(value = ["/certificate/{certificate-id}"])
    fun fetchCertificate(
        @PathVariable("certificate-id") certificateId: String
    ) = ResponseEntity(tidKmsService.fetchCertificatePem(certificateId), HttpStatus.OK)

    @GetMapping(value = ["/private-key/{private-key-id}"])
    fun fetchPrivateKey(
        @PathVariable("private-key-id") privateKeyId: String
    ) = ResponseEntity(tidKmsService.fetchPrivateKeyPem(privateKeyId), HttpStatus.OK)

}
