package com.netki.sapphire.controller

import com.netki.model.InvoiceRequestParameters
import com.netki.model.PaymentAckParameters
import com.netki.model.PaymentParameters
import com.netki.model.PaymentRequestParameters
import com.netki.sapphire.model.*
import com.netki.sapphire.service.Bip75Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2/bip75")
class Bip75Controller {

    @Autowired
    private lateinit var bip75Service: Bip75Service

    @GetMapping(value = ["/welcome"])
    fun welcome(): String {
        return "Welcome controller!!"
    }

    @PostMapping(value = ["/invoice-request"])
    fun createInvoiceRequest(
        @RequestBody invoiceRequestParameters: InvoiceRequestParameters
    ) = ResponseEntity(
        bip75Service.createInvoiceRequest(invoiceRequestParameters).toProtocolMessageResponse(),
        HttpStatus.CREATED
    )

    @PostMapping(value = ["/invoice-request/validate"])
    fun isInvoiceRequestValid(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.isInvoiceRequestValid(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/invoice-request/parse"])
    fun parseInvoiceRequest(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.parseInvoiceRequest(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/invoice-request/parse-with-address-info"])
    fun parseInvoiceRequestWithAddressesInfo(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.parseInvoiceRequestWithAddressesInfo(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ),
        HttpStatus.OK
    )

    @PostMapping(value = ["/payment-request"])
    fun createPaymentRequest(
        @RequestBody paymentRequestPayload: PaymentRequestPayload
    ) = ResponseEntity(
        bip75Service.createPaymentRequest(paymentRequestPayload).toProtocolMessageResponse(),
        HttpStatus.CREATED
    )

    @PostMapping(value = ["/payment-request/validate"])
    fun isPaymentRequestValid(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.isPaymentRequestValid(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/payment-request/parse"])
    fun parsePaymentRequest(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.parsePaymentRequest(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/payment-request/parse-with-address-info"])
    fun parsePaymentRequestWithAddressesInfo(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.parsePaymentRequestWithAddressesInfo(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ),
        HttpStatus.OK
    )

    @PostMapping(value = ["/payment"])
    fun createPayment(
        @RequestBody paymentPayload: PaymentPayload
    ) = ResponseEntity(
        bip75Service.createPayment(paymentPayload).toProtocolMessageResponse(),
        HttpStatus.CREATED
    )

    @PostMapping(value = ["/payment/validate"])
    fun isPaymentValid(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.isPaymentValid(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/payment/parse"])
    fun parsePayment(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.parsePayment(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/payment-ack"])
    fun createPaymentAck(
        @RequestBody paymentAckPayload: PaymentAckPayload
    ) = ResponseEntity(
        bip75Service.createPaymentAck(paymentAckPayload).toProtocolMessageResponse(),
        HttpStatus.CREATED
    )

    @PostMapping(value = ["/payment-ack/validate"])
    fun isPaymentAckValid(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.isPaymentAckValid(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/payment-ack/parse"])
    fun parsePaymentAck(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.parsePaymentAck(
            protocolMessage.getProtocolMessageBytes(),
            protocolMessage.recipientParameters
        ), HttpStatus.OK
    )

    @PostMapping(value = ["/message/change-status"])
    fun changeStatusMessageProtocol(
        @RequestBody protocolMessage: ProtocolMessage
    ): ResponseEntity<Any> {
        protocolMessage.messageInformation?.let {
            return ResponseEntity(
                bip75Service.changeStatusMessageProtocol(
                    protocolMessage.getProtocolMessageBytes(),
                    it.statusCode,
                    it.statusMessage
                ).toProtocolMessageResponse(),
                HttpStatus.OK
            )
        } ?: return ResponseEntity(
            ServiceError(ServiceErrorType.INVALID_DATA, "Missing new status information"),
            HttpStatus.BAD_REQUEST
        )
    }

    @PostMapping(value = ["/message/metadata"])
    fun getProtocolMessageMetadata(
        @RequestBody protocolMessage: ProtocolMessage
    ) = ResponseEntity(
        bip75Service.getProtocolMessageMetadata(protocolMessage.getProtocolMessageBytes()),
        HttpStatus.OK
    )
}
