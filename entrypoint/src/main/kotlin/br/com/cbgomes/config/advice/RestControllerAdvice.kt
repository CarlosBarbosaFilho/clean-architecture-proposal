package br.com.cbgomes.config.advice

import br.com.cbgomes.exception.ErrorResponse
import br.com.cbgomes.exception.ExternalCommunicationFailureException
import br.com.cbgomes.exception.ResourceAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@RestControllerAdvice
class RestControllerAdvice {
    @ExceptionHandler(ResourceAlreadyExistsException::class)
    fun handleResourceAlreadyExistsException(
        ex: ResourceAlreadyExistsException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> =
        ex.toErrorResponseWithHttpStatus(httpStatus = HttpStatus.CONFLICT, request = request)

    @ExceptionHandler(ExternalCommunicationFailureException::class)
    fun handleExternalCommunicationFailureException(ex: ExternalCommunicationFailureException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(ex.statusCode).body(
            ErrorResponse(
                timestamp = LocalDateTime.now(),
                code = ex.statusCode.value(),
                message = ex.errorMessage.toString()
            )
        )
    }


    private fun Throwable.toErrorResponseWithHttpStatus(
        httpStatus: HttpStatus,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(httpStatus).body(
            ErrorResponse(
                timestamp = LocalDateTime.now(),
                code = httpStatus.value(),
                message = request.toContextErrorMessage(this)
            )
        )

    private fun WebRequest.toContextErrorMessage(t: Throwable): String =
        with(this as ServletWebRequest) {
            "${t.message} [${httpMethod?.name} path = ${request.requestURI}]"
        }
}
