package com.aoeai.rg.double_color_ball.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LotteryDrawMachineTest{

    @DisplayName("红球号码区包含 1～33 个数字")
    @Test
    fun `red ball area contains 1 to 33 numbers`() {
        val redBallArea = LotteryDrawMachine.redBallArea()

        for (i in 1..33) {
            assertThat(redBallArea).contains(i)
        }
    }

    @DisplayName("摇出的红球号码共 6 个数字")
    @Test
    fun `draw 6 red balls`() {
        val redBalls = LotteryDrawMachine.drawRedBalls()

        assertThat(redBalls).hasSize(6)
    }

    @DisplayName("摇出的红球号码不存在重复数字")
    @Test
    fun `draw red balls without duplicate numbers`() {
        val redBalls = LotteryDrawMachine.drawRedBalls()

        assertThat(redBalls).doesNotHaveDuplicates()
    }

    @DisplayName("摇出的红球号码按升序排列")
    @Test
    fun `draw red balls in ascending order`() {
        val redBalls = LotteryDrawMachine.drawRedBalls()

        assertThat(redBalls).isSorted()
    }

    @DisplayName("蓝球号码区包含 1～16 个数字")
    @Test
    fun `blue ball area contains 1 to 16 numbers`() {
        val blueBallArea = LotteryDrawMachine.blueBallArea()

        for (i in 1..16) {
            assertThat(blueBallArea).contains(i)
        }
    }

    @DisplayName("摇出的红球号码在 1～33 之间")
    @Test
    fun `draw red balls between 1 and 33`() {
        val redBalls = LotteryDrawMachine.drawRedBalls()

        assertThat(redBalls).allMatch { it in 1..33 }
    }

    @DisplayName("摇出的蓝球号码在 1～16 之间")
    @Test
    fun `draw blue balls between 1 and 16`() {
        val blueBall = LotteryDrawMachine.drawBlueBall()

        assertThat(blueBall).isBetween(1, 16)
    }
}

