package com.netki.sapphire.model

import com.netki.model.MessageInformation
import com.netki.model.Payment

data class PaymentAckPayload(
    val payment: Payment,
    val memo: String,
    val messageInformation: MessageInformation = MessageInformation()
)
