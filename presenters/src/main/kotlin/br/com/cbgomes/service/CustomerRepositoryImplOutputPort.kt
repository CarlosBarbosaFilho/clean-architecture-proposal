package br.com.cbgomes.service

import br.com.cbgomes.data.CustomerInputPort
import br.com.cbgomes.data.CustomerOutputPort
import br.com.cbgomes.domain.toCustomer
import br.com.cbgomes.domain.toCustomerOutputPort
import br.com.cbgomes.ports.output.UseCaseCustomerOutputPort
import br.com.cbgomes.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerRepositoryImplOutputPort(
    private val customerRepository: CustomerRepository
): UseCaseCustomerOutputPort {

    override fun list(): MutableList<CustomerOutputPort> {
        return this.customerRepository.findAll()
            .map { it.toCustomerOutputPort() }
            .toMutableList()
    }

    override fun create(customerInputPort: CustomerInputPort): CustomerOutputPort {
       return  this.customerRepository.save(customerInputPort.toCustomer()).toCustomerOutputPort()
    }
}