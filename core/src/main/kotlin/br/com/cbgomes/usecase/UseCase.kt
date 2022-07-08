package br.com.cbgomes.usecase

import br.com.cbgomes.data.CustomerInputPort
import br.com.cbgomes.ports.input.UseCaseCustomerInputPort
import br.com.cbgomes.data.CustomerOutputPort
import br.com.cbgomes.ports.output.UseCaseCustomerOutputPort
import org.springframework.stereotype.Service

@Service
class UseCase(
    private val useCaseCustomerOutputPort: UseCaseCustomerOutputPort
) : UseCaseCustomerInputPort {
    override fun list(): MutableList<CustomerOutputPort> {
        return this.useCaseCustomerOutputPort.list()
    }

    override fun create(customerInputPort: CustomerInputPort): CustomerOutputPort {
        return this.useCaseCustomerOutputPort.create(customerInputPort)
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): CustomerOutputPort {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, customerInputPort: CustomerInputPort) {
        TODO("Not yet implemented")
    }


}
