package com.netki.sapphire.model

import com.netki.model.*

data class PaymentPayload(
    val paymentParameters: PaymentParameters,
    val ownersParameters: List<OwnerParameters>,
    val messageInformation: MessageInformation = MessageInformation(),
    val senderParameters: SenderParameters? = null,
    val recipientParameters: RecipientParameters? = null
)
