package br.com.cbgomes.exception

import java.time.LocalDateTime

data class ErrorResponse(
    val timestamp: LocalDateTime,
    val code: Int,
    val message: String,
    val details: Map<String, Any> = mapOf()
)
