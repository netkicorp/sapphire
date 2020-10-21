package com.netki.sapphire.model

import com.netki.model.RecipientParameters
import java.util.*

val encoder: Base64.Encoder = Base64.getEncoder()
val decoder: Base64.Decoder = Base64.getDecoder()

data class ProtocolMessage(
    /**
     * Base64 String containing the protocol message.
     */
    val protocolMessage: String,

    /**
     * Recipient of the message parameters, these are needed when the message is encrypted.
     */
    val recipientParameters: RecipientParameters? = null
)

fun ByteArray.toProtocolMessageResponse() = ProtocolMessage(
    protocolMessage = encoder.encodeToString(this)
)

fun ProtocolMessage.getProtocolMessageBytes(): ByteArray = decoder.decode(this.protocolMessage)
