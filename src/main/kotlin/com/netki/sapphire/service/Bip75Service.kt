package com.netki.sapphire.service

import com.netki.TransactId
import com.netki.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Bip75Service {

    @Autowired
    private lateinit var tid: TransactId

    fun createInvoiceRequest(invoiceRequestParameters: InvoiceRequestParameters) =
        tid.createInvoiceRequest(invoiceRequestParameters)

    fun isInvoiceRequestValid(
        invoiceRequestBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.isInvoiceRequestValid(invoiceRequestBinary, recipientParameters)

    fun parseInvoiceRequest(
        invoiceRequestBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parseInvoiceRequest(invoiceRequestBinary, recipientParameters)

    fun parseInvoiceRequestWithAddressesInfo(
        invoiceRequestBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parseInvoiceRequestWithAddressesInfo(invoiceRequestBinary, recipientParameters)

    fun createPaymentRequest(paymentRequestParameters: PaymentRequestParameters) =
        tid.createPaymentRequest(paymentRequestParameters)

    fun isPaymentRequestValid(
        paymentRequestBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.isPaymentRequestValid(paymentRequestBinary, recipientParameters)

    fun parsePaymentRequest(
        paymentRequestBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parsePaymentRequest(paymentRequestBinary, recipientParameters)

    fun parsePaymentRequestWithAddressesInfo(
        paymentRequestBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parsePaymentRequestWithAddressesInfo(paymentRequestBinary, recipientParameters)

    fun createPayment(paymentParameters: PaymentParameters) = tid.createPayment(paymentParameters)

    fun isPaymentValid(
        paymentBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.isPaymentValid(paymentBinary, recipientParameters)

    fun parsePayment(
        paymentBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parsePayment(paymentBinary, recipientParameters)

    fun createPaymentAck(paymentAckParameters: PaymentAckParameters) =
        tid.createPaymentAck(paymentAckParameters)

    fun isPaymentAckValid(
        paymentAckBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.isPaymentAckValid(paymentAckBinary, recipientParameters)

    fun parsePaymentAck(
        paymentAckBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parsePaymentAck(paymentAckBinary, recipientParameters)

    fun changeStatusMessageProtocol(
        protocolMessage: ByteArray,
        statusCode: StatusCode,
        statusMessage: String = ""
    ) = tid.changeStatusMessageProtocol(protocolMessage, statusCode, statusMessage)

    fun getProtocolMessageMetadata(
        protocolMessage: ByteArray
    ) = tid.getProtocolMessageMetadata(protocolMessage)
}
