package com.netki.sapphire.model

import com.netki.model.PaymentRequestParameters

data class PaymentRequestPayload(
    val paymentRequestParameters: PaymentRequestParameters,
    val identifier: String
)
