package org.dev

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class Service(
    private val customerRepository: CustomerRepository
) {

    @PostConstruct
    fun test() {
        val customerWithName = Customer(id = 1, name = "John", age = 25)
        val customerWithoutName = Customer(id = 2, name = null, age = 33)
        customerRepository.save(customerWithName)
        customerRepository.save(customerWithoutName)
        val customers = customerRepository.customProjectionQuery()
        for (customer in customers) {
            println(customer.name)
        }
    }
}