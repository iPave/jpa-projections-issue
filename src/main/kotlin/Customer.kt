package org.dev

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Customer(
    @Id
    val id: Long? = null,

    var name: String? = null,

    val age: Int
)