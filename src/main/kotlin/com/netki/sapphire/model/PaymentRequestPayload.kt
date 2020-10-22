package com.netki.sapphire.model

import com.netki.model.*

data class PaymentRequestPayload(
    val paymentRequestParameters: PaymentRequestParameters,
    val ownersParameters: List<OwnerParameters>,
    val senderParameters: SenderParameters,
    val attestationsRequested: List<Attestation>,
    val paymentRequestParametersVersion: Int,
    val messageInformation: MessageInformation = MessageInformation(),
    val recipientParameters: RecipientParameters? = null
)
