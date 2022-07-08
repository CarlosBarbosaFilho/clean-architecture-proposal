package br.com.cbgomes.request

import br.com.cbgomes.data.CustomerInputPort


data class CustomerRequest(
    val name: String,
    val email: String,
    val phone: String,
)


fun CustomerRequest.toCustomerInputPort(): CustomerInputPort {
    return CustomerInputPort(
        name = name,
        email = email,
        phone = phone
    )
}
