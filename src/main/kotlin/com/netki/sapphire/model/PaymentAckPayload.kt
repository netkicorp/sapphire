package com.netki.sapphire.model

import com.netki.model.PaymentAckParameters

data class PaymentAckPayload(
    val paymentAckParameters: PaymentAckParameters,
    val identifier: String
)
