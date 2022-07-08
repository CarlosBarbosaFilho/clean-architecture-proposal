package br.com.cbgomes.controller

import br.com.cbgomes.data.CustomerInputPort
import br.com.cbgomes.ports.input.UseCaseCustomerInputPort
import br.com.cbgomes.request.CustomerRequest
import br.com.cbgomes.request.toCustomerInputPort
import br.com.cbgomes.response.CustomerResponse
import br.com.cbgomes.response.toResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(value = "/api/customers")
@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(

    private val useCaseCustomerInputPort: UseCaseCustomerInputPort
)
{
    @ApiResponse(code = 200, message = "List all customers with success")
    @ApiOperation(value = "Return all customers")
    @GetMapping
    fun customers(): MutableList<CustomerResponse> {
      return useCaseCustomerInputPort.list()
          .map { it -> it.toResponse() }
          .toMutableList()
    }

    @ApiResponse(code = 201, message = "Create a customer with success")
    @ApiOperation(value = "Create customer")
    @PostMapping
    fun create(@RequestBody customerRequest: CustomerRequest): ResponseEntity<CustomerResponse> {
        return ResponseEntity.ok(this.useCaseCustomerInputPort.create(customerRequest.toCustomerInputPort())
            .toResponse())
    }

}
