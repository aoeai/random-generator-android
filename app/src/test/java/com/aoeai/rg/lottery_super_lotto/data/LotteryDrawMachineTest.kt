package com.aoeai.rg.lottery_super_lotto.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LotteryDrawMachineTest{
    @DisplayName("前区号码区包含 1～35 个数字")
    @Test
    fun `front area contains 1 to 35 numbers`() {
        val frontArea = LotteryDrawMachine.frontArea()

        for (i in 1..35) {
            assertThat(frontArea).contains(i)
        }
    }

    @DisplayName("摇出的前区号码共 5 个数字")
    @Test
    fun `draw 5 front area balls`() {
        val frontAreaBalls = LotteryDrawMachine.drawFrontArea()

        assertThat(frontAreaBalls).hasSize(5)
    }

    @DisplayName("摇出的前区号码不存在重复数字")
    @Test
    fun `draw front area balls without duplicate numbers`() {
        val frontAreaBalls = LotteryDrawMachine.drawFrontArea()

        assertThat(frontAreaBalls).doesNotHaveDuplicates()
    }

    @DisplayName("摇出的前区号码按升序排列")
    @Test
    fun `draw front area balls in ascending order`() {
        val frontAreaBalls = LotteryDrawMachine.drawFrontArea()

        assertThat(frontAreaBalls).isSorted()
    }

    @DisplayName("后区号码区包含 1～12 个数字")
    @Test
    fun `back area contains 1 to 12 numbers`() {
        val backArea = LotteryDrawMachine.backArea()

        for (i in 1..12) {
            assertThat(backArea).contains(i)
        }
    }

    @DisplayName("摇出的后区号码共 2 个数字")
    @Test
    fun `draw 2 back area balls`() {
        val backAreaBalls = LotteryDrawMachine.drawBackArea()

        assertThat(backAreaBalls).hasSize(2)
    }

    @DisplayName("摇出的后区号码不存在重复数字")
    @Test
    fun `draw back area balls without duplicate numbers`() {
        val backAreaBalls = LotteryDrawMachine.drawBackArea()

        assertThat(backAreaBalls).doesNotHaveDuplicates()
    }

    @DisplayName("摇出的后区号码按升序排列")
    @Test
    fun `draw back area balls in ascending order`() {
        val backAreaBalls = LotteryDrawMachine.drawBackArea()

        assertThat(backAreaBalls).isSorted()
    }
}