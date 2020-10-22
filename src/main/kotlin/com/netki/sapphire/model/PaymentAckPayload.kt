package com.netki.sapphire.model

import com.netki.model.MessageInformation
import com.netki.model.Payment
import com.netki.model.RecipientParameters
import com.netki.model.SenderParameters

data class PaymentAckPayload(
    val payment: Payment,
    val memo: String,
    val messageInformation: MessageInformation = MessageInformation(),
    val senderParameters: SenderParameters? = null,
    val recipientParameters: RecipientParameters? = null
)
