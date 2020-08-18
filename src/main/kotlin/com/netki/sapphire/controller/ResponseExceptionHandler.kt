package com.netki.sapphire.controller

import com.netki.exceptions.*
import com.netki.sapphire.model.ServiceError
import com.netki.sapphire.model.ServiceErrorType
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleProviderErrorsError(exception: Exception, request: WebRequest): ResponseEntity<ServiceError> {
        var serviceErrorType: ServiceErrorType
        var httpStatus: HttpStatus

        when (exception) {
            is AddressProviderErrorException -> {
                serviceErrorType = ServiceErrorType.ADDRESS_PROVIDER_ERROR
                httpStatus = HttpStatus.BAD_GATEWAY
            }
            is AddressProviderUnauthorizedException -> {
                serviceErrorType = ServiceErrorType.ADDRESS_PROVIDER_UNAUTHORIZED
                httpStatus = HttpStatus.UNAUTHORIZED
            }
            is CertificateProviderException -> {
                serviceErrorType = ServiceErrorType.CERTIFICATE_PROVIDER
                httpStatus = HttpStatus.BAD_GATEWAY
            }
            is CertificateProviderUnauthorizedException -> {
                serviceErrorType = ServiceErrorType.CERTIFICATE_PROVIDER_UNAUTHORIZED
                httpStatus = HttpStatus.UNAUTHORIZED
            }
            is InvalidCertificateChainException -> {
                serviceErrorType = ServiceErrorType.INVALID_CERTIFICATE_CHAIN
                httpStatus = HttpStatus.BAD_REQUEST
            }
            is InvalidCertificateException -> {
                serviceErrorType = ServiceErrorType.INVALID_CERTIFICATE
                httpStatus = HttpStatus.BAD_REQUEST
            }
            is InvalidObjectException -> {
                serviceErrorType = ServiceErrorType.INVALID_OBJECT
                httpStatus = HttpStatus.BAD_REQUEST
            }
            is InvalidOwnersException -> {
                serviceErrorType = ServiceErrorType.INVALID_OWNERS
                httpStatus = HttpStatus.BAD_REQUEST
            }
            is InvalidPrivateKeyException -> {
                serviceErrorType = ServiceErrorType.INVALID_PRIVATE_KEY
                httpStatus = HttpStatus.BAD_REQUEST
            }
            is InvalidSignatureException -> {
                serviceErrorType = ServiceErrorType.INVALID_SIGNATURE
                httpStatus = HttpStatus.BAD_REQUEST
            }
            is KeyManagementFetchException -> {
                serviceErrorType = ServiceErrorType.KEY_MANAGEMENT_FETCH
                httpStatus = HttpStatus.BAD_GATEWAY
            }
            is KeyManagementStoreException -> {
                serviceErrorType = ServiceErrorType.KEY_MANAGEMENT_STORE
                httpStatus = HttpStatus.BAD_GATEWAY
            }
            is ObjectNotFoundException -> {
                serviceErrorType = ServiceErrorType.OBJECT_NOT_FOUND
                httpStatus = HttpStatus.NOT_FOUND
            }
            else -> {
                serviceErrorType = ServiceErrorType.UNKNOWN
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
            }
        }

        return ResponseEntity(
            ServiceError(serviceErrorType, exception.localizedMessage),
            httpStatus
        )
    }
}
