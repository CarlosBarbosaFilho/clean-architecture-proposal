package br.com.cbgomes.ports.input

import br.com.cbgomes.data.CustomerInputPort
import br.com.cbgomes.data.CustomerOutputPort


interface UseCaseCustomerInputPort {

    fun list(): MutableList<CustomerOutputPort>
    fun create(customerInputPort: CustomerInputPort): CustomerOutputPort
    fun delete(id: Long)
    fun findById(id: Long): CustomerOutputPort
    fun update(id: Long, customerInputPort: CustomerInputPort)
}
