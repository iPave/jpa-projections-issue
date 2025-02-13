package org.dev

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Int> {


    @Query("select c.name as name, c.age as age from Customer c")
    fun customProjectionQuery(): List<NameWithAgeOnlyInt>

    @Query("select c.name as name, c.age as age from Customer c")
    fun customProjectionQueryDto(): List<NameWithAgeOnly>

}

interface NameWithAgeOnlyInt {
    val name: String
    val age: Int
}

data class NameWithAgeOnly(
    val name: String,
    val age: Int
)