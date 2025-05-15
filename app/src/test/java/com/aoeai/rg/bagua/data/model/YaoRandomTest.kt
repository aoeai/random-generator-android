package com.aoeai.rg.bagua.data.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class YaoRandomTest {

    @DisplayName("返回值应为0或1")
    @Test
    fun `should return 0 or 1`() {
        val resultSet = mutableSetOf<Int>()

        for (i in 1..100) {
            resultSet.add(YaoRandom.next())
        }

        assertThat(resultSet).containsExactlyInAnyOrder(0, 1)
    }
}