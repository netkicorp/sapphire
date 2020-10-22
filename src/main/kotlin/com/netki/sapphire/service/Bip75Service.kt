package com.netki.sapphire.service

import com.netki.TransactId
import com.netki.model.RecipientParameters
import com.netki.sapphire.model.InvoiceRequestPayload
import com.netki.sapphire.model.PaymentAckPayload
import com.netki.sapphire.model.PaymentPayload
import com.netki.sapphire.model.PaymentRequestPayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Bip75Service {

    @Autowired
    private lateinit var tid: TransactId

    fun createInvoiceRequest(invoiceRequestPayload: InvoiceRequestPayload) =
        tid.createInvoiceRequest(
            invoiceRequestPayload.invoiceRequestParameters,
            invoiceRequestPayload.ownersParameters,
            invoiceRequestPayload.senderParameters,
            invoiceRequestPayload.attestationsRequested,
            invoiceRequestPayload.recipientParameters,
            invoiceRequestPayload.messageInformation
        )

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

    fun createPaymentRequest(paymentRequestPayload: PaymentRequestPayload) =
        tid.createPaymentRequest(
            paymentRequestPayload.paymentRequestParameters,
            paymentRequestPayload.ownersParameters,
            paymentRequestPayload.senderParameters,
            paymentRequestPayload.attestationsRequested,
            paymentRequestPayload.paymentRequestParametersVersion,
            paymentRequestPayload.messageInformation,
            paymentRequestPayload.recipientParameters
        )

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

    fun createPayment(paymentPayload: PaymentPayload) = tid.createPayment(
        paymentPayload.paymentParameters,
        paymentPayload.ownersParameters,
        paymentPayload.messageInformation,
        paymentPayload.senderParameters,
        paymentPayload.recipientParameters
    )

    fun isPaymentValid(
        paymentBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.isPaymentValid(paymentBinary, recipientParameters)

    fun parsePayment(
        paymentBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parsePayment(paymentBinary, recipientParameters)

    fun createPaymentAck(paymentAckPayload: PaymentAckPayload) = tid.createPaymentAck(
        paymentAckPayload.payment,
        paymentAckPayload.memo,
        paymentAckPayload.messageInformation,
        paymentAckPayload.senderParameters,
        paymentAckPayload.recipientParameters
    )

    fun isPaymentAckValid(
        paymentAckBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.isPaymentAckValid(paymentAckBinary, recipientParameters)

    fun parsePaymentAck(
        paymentAckBinary: ByteArray,
        recipientParameters: RecipientParameters? = null
    ) = tid.parsePaymentAck(paymentAckBinary, recipientParameters)
}
