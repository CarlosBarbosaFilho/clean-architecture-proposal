package br.com.cbgomes.domain

import br.com.cbgomes.data.CustomerInputPort
import br.com.cbgomes.data.CustomerOutputPort
import javax.persistence.*

@Entity
@Table(name = "tb_customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_customer")
    @SequenceGenerator(name = "seq_customer", sequenceName = "customer_id_seq")
    val id: Long? = null,
    val name: String = "",
    val email: String = "",
    val phone: String = ""
)

fun Customer.toCustomerOutputPort(): CustomerOutputPort {
    return CustomerOutputPort(
        id = id,
        name = name,
        email = email,
        phone = phone
    )
}

fun CustomerInputPort.toCustomer(): Customer {
    return Customer(
        id = null,
        name = name,
        email = email,
        phone = phone
    )
}