package com.walter.jdsl.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import com.walter.jdsl.entity.Actor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActorRepository : JpaRepository<Actor, Long>, KotlinJdslJpqlExecutor