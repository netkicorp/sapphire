package com.netki.sapphire.model

import com.netki.model.MessageInformation
import com.netki.model.OwnerParameters
import com.netki.model.PaymentParameters

data class PaymentPayload(
    val paymentParameters: PaymentParameters,
    val ownersParameters: List<OwnerParameters>,
    val messageInformation: MessageInformation = MessageInformation()
)
