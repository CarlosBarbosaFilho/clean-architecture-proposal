package br.com.cbgomes.response

import br.com.cbgomes.data.CustomerOutputPort


data class CustomerResponse(
    val id: Long?,
    val name: String,
    val email: String,
    val phone: String,
)

fun CustomerOutputPort.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = id ,
        name = name,
        email = email,
        phone = phone
    )
}