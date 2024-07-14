package com.walter.jdsl

import com.linecorp.kotlinjdsl.dsl.jpql.jpql
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderContext
import com.linecorp.kotlinjdsl.support.spring.data.jpa.extension.createQuery
import com.walter.jdsl.entity.Actor
import com.walter.jdsl.model.ActorSimpleInfo
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JdslQueryTest(
    @Autowired val entityManager: EntityManager,
    @Autowired val context: JpqlRenderContext,
) {
    @Test
    @DisplayName("Actor 테이블의 배우 1명의 이름을 조회한다.")
    fun selectActorSimpleInfoTest() {
        // given
        val actorId = 1L

        // when
        val query = jpql {
            selectNew<ActorSimpleInfo>(
                path(Actor::firstName),
                path(Actor::lastName)
            ).from(
                entity(Actor::class)
            ).where(
                path(Actor::actorId).eq(actorId)
            )
        }
        val jpaQuery = entityManager.createQuery(query, context)
        val result = jpaQuery.singleResult

        // then
        assertThat(result).isNotNull()
        assertThat(result).hasNoNullFieldsOrProperties()
    }
}