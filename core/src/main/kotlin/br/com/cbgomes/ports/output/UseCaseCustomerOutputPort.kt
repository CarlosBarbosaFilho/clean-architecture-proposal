package br.com.cbgomes.ports.output

import br.com.cbgomes.data.CustomerInputPort
import br.com.cbgomes.data.CustomerOutputPort


interface UseCaseCustomerOutputPort {

    fun list(): MutableList<CustomerOutputPort>

    fun create(customerInputPort: CustomerInputPort): CustomerOutputPort
}
