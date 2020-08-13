package com.netki.sapphire.model

import com.netki.model.Attestation
import com.netki.model.OwnerParameters
import com.netki.model.PaymentRequestParameters
import com.netki.model.SenderParameters

data class PaymentRequestPayload(
    val paymentRequestParameters: PaymentRequestParameters,
    val ownersParameters: List<OwnerParameters>,
    val senderParameters: SenderParameters,
    val attestationsRequested: List<Attestation>,
    val paymentRequestParametersVersion: Int
)
