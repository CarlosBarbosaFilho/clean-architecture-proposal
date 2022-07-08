package br.com.cbgomes.helper

import br.com.cbgomes.exception.ExternalCommunicationFailureException
import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus

abstract class ClientErrorDecoder : ErrorDecoder {

    protected abstract val errorMap: Map<HttpStatus, (String) -> Exception?>

    override fun decode(methodKey: String?, response: Response): Exception {
        val body: String = response.body()?.asInputStream()?.bufferedReader().use { it?.readText() } ?: ""
        return retrieveException(body, HttpStatus.valueOf(response.status()))
    }

    protected open fun retrieveException(body: String, status: HttpStatus): Exception =
        errorMap[status]?.invoke(body)
            ?: ExternalCommunicationFailureException(
                HttpStatus.BAD_REQUEST,
                "A generic error occurred while trying to dispatch client call [status = $status, body = $body]"
            )
}
