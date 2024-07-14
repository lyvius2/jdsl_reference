package com.walter.jdsl.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "actor")
data class Actor(
    @Id
    @Column(name = "actor_id")
    val actorId: Long,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "last_update")
    var lastUpdate: LocalDateTime,
)
