package com.netki.sapphire.controller

import com.netki.sapphire.model.InvoiceRequestPayload
import com.netki.sapphire.model.PaymentAckPayload
import com.netki.sapphire.model.PaymentPayload
import com.netki.sapphire.model.PaymentRequestPayload
import com.netki.sapphire.service.Bip75Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
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
    ): ByteArray {
        println(invoiceRequestPayload)
        return bip75Service.createInvoiceRequest(invoiceRequestPayload)
    }

    @PostMapping(value = ["/invoice-request/validate"])
    fun isInvoiceRequestValid(
        @RequestBody invoiceRequestBinary: ByteArray
    ) = bip75Service.isInvoiceRequestValid(invoiceRequestBinary)

    @PostMapping(value = ["/invoice-request/parse"])
    fun parseInvoiceRequest(
        @RequestBody invoiceRequestBinary: ByteArray
    ) = bip75Service.parseInvoiceRequest(invoiceRequestBinary)

    @PostMapping(value = ["/payment-request"])
    fun createInvoiceRequest(
        @RequestBody paymentRequestPayload: PaymentRequestPayload
    ) = bip75Service.createPaymentRequest(paymentRequestPayload)

    @PostMapping(value = ["/payment-request/validate"])
    fun isPaymentRequestValid(
        @RequestBody paymentRequestBinary: ByteArray
    ) = bip75Service.isPaymentRequestValid(paymentRequestBinary)

    @PostMapping(value = ["/payment-request/parse"])
    fun parsePaymentRequest(
        @RequestBody paymentRequestBinary: ByteArray
    ) = bip75Service.parsePaymentRequest(paymentRequestBinary)

    @PostMapping(value = ["/payment"])
    fun createPayment(
        @RequestBody paymentPayload: PaymentPayload
    ) = bip75Service.createPayment(paymentPayload)

    @PostMapping(value = ["/payment/validate"])
    fun isPaymentValid(
        @RequestBody paymentBinary: ByteArray
    ) = bip75Service.isPaymentValid(paymentBinary)

    @PostMapping(value = ["/payment/parse"])
    fun parsePayment(
        @RequestBody paymentBinary: ByteArray
    ) = bip75Service.parsePayment(paymentBinary)

    @PostMapping(value = ["/payment-ack"])
    fun createPaymentAck(
        @RequestBody paymentAckPayload: PaymentAckPayload
    ) = bip75Service.createPaymentAck(paymentAckPayload)

    @PostMapping(value = ["/payment-ack/validate"])
    fun isPaymentAckValid(
        @RequestBody paymentAckBinary: ByteArray
    ) = bip75Service.isPaymentAckValid(paymentAckBinary)

    @PostMapping(value = ["/payment-ack/parse"])
    fun parsePaymentAck(
        @RequestBody paymentAckBinary: ByteArray
    ) = bip75Service.parsePaymentAck(paymentAckBinary)
}
