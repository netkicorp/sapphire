package com.netki.sapphire.model

data class ServiceError(
    var type: ServiceErrorType,
    val message: String
)
