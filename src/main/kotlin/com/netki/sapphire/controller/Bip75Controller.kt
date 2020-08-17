package com.netki.sapphire.controller

import com.netki.sapphire.model.InvoiceRequestPayload
import com.netki.sapphire.model.PaymentAckPayload
import com.netki.sapphire.model.PaymentPayload
import com.netki.sapphire.model.PaymentRequestPayload
import com.netki.sapphire.service.Bip75Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/bip75")
class Bip75Controller {

    @Autowired
    private lateinit var bip75Service: Bip75Service

    @GetMapping(value = ["/welcome"])
    fun welcome(): String {
        return "Welcome controller!!"
    }

    @PostMapping(value = ["/invoice-request"])
    fun createInvoiceRequest(
        @RequestBody invoiceRequestPayload: InvoiceRequestPayload
    ) = ResponseEntity(bip75Service.createInvoiceRequest(invoiceRequestPayload), HttpStatus.CREATED)

    @PostMapping(value = ["/invoice-request/validate"])
    fun isInvoiceRequestValid(
        @RequestBody invoiceRequestBinary: ByteArray
    ) = ResponseEntity(bip75Service.isInvoiceRequestValid(invoiceRequestBinary), HttpStatus.OK)

    @PostMapping(value = ["/invoice-request/parse"])
    fun parseInvoiceRequest(
        @RequestBody invoiceRequestBinary: ByteArray
    ) = ResponseEntity(bip75Service.parseInvoiceRequest(invoiceRequestBinary), HttpStatus.OK)

    @PostMapping(value = ["/invoice-request/parse-with-address-info"])
    fun parseInvoiceRequestWithAddressesInfo(
        @RequestBody invoiceRequestBinary: ByteArray
    ) = ResponseEntity(bip75Service.parseInvoiceRequestWithAddressesInfo(invoiceRequestBinary), HttpStatus.OK)

    @PostMapping(value = ["/payment-request"])
    fun createPaymentRequest(
        @RequestBody paymentRequestPayload: PaymentRequestPayload
    ) = ResponseEntity(bip75Service.createPaymentRequest(paymentRequestPayload), HttpStatus.CREATED)

    @PostMapping(value = ["/payment-request/validate"])
    fun isPaymentRequestValid(
        @RequestBody paymentRequestBinary: ByteArray
    ) = ResponseEntity(bip75Service.isPaymentRequestValid(paymentRequestBinary), HttpStatus.OK)

    @PostMapping(value = ["/payment-request/parse"])
    fun parsePaymentRequest(
        @RequestBody paymentRequestBinary: ByteArray
    ) = ResponseEntity(bip75Service.parsePaymentRequest(paymentRequestBinary), HttpStatus.OK)

    @PostMapping(value = ["/payment-request/parse-with-address-info"])
    fun parsePaymentRequestWithAddressesInfo(
        @RequestBody paymentRequestBinary: ByteArray
    ) = ResponseEntity(bip75Service.parsePaymentRequestWithAddressesInfo(paymentRequestBinary), HttpStatus.OK)

    @PostMapping(value = ["/payment"])
    fun createPayment(
        @RequestBody paymentPayload: PaymentPayload
    ) = ResponseEntity(bip75Service.createPayment(paymentPayload), HttpStatus.CREATED)

    @PostMapping(value = ["/payment/validate"])
    fun isPaymentValid(
        @RequestBody paymentBinary: ByteArray
    ) = ResponseEntity(bip75Service.isPaymentValid(paymentBinary), HttpStatus.OK)

    @PostMapping(value = ["/payment/parse"])
    fun parsePayment(
        @RequestBody paymentBinary: ByteArray
    ) = ResponseEntity(bip75Service.parsePayment(paymentBinary), HttpStatus.OK)

    @PostMapping(value = ["/payment-ack"])
    fun createPaymentAck(
        @RequestBody paymentAckPayload: PaymentAckPayload
    ) = ResponseEntity(bip75Service.createPaymentAck(paymentAckPayload), HttpStatus.CREATED)

    @PostMapping(value = ["/payment-ack/validate"])
    fun isPaymentAckValid(
        @RequestBody paymentAckBinary: ByteArray
    ) = ResponseEntity(bip75Service.isPaymentAckValid(paymentAckBinary), HttpStatus.OK)

    @PostMapping(value = ["/payment-ack/parse"])
    fun parsePaymentAck(
        @RequestBody paymentAckBinary: ByteArray
    ) = ResponseEntity(bip75Service.parsePaymentAck(paymentAckBinary), HttpStatus.OK)
}
