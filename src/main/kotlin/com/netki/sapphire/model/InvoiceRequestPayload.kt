package com.netki.sapphire.model

import com.netki.model.*

data class InvoiceRequestPayload(
    val invoiceRequestParameters: InvoiceRequestParameters,
    val ownersParameters: List<OwnerParameters>,
    val senderParameters: SenderParameters,
    val attestationsRequested: List<Attestation>,
    val recipientParameters: RecipientParameters?
)
