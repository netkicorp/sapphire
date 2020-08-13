package com.netki.sapphire.model

import com.netki.model.Attestation
import com.netki.model.InvoiceRequestParameters
import com.netki.model.OwnerParameters
import com.netki.model.SenderParameters

data class InvoiceRequestPayload(
    val invoiceRequestParameters: InvoiceRequestParameters,
    val ownersParameters: List<OwnerParameters>,
    val senderParameters: SenderParameters,
    val attestationsRequested: List<Attestation>
)
