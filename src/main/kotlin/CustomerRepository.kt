package org.dev

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Int> {


    @Query("select c.name from Customer c")
    fun customProjectionQuery(): List<NameWithAgeOnlyInt>

    @Query("select c.name from Customer c")
    fun customProjectionQuerDto(): List<NameWithAgeOnly>

}

interface NameWithAgeOnlyInt {
    val name: String
    val age: Int
}

data class NameWithAgeOnly(
    val name: String,
    val age: Int
)