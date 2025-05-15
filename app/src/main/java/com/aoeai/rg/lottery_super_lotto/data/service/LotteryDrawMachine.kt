package com.aoeai.rg.lottery_super_lotto.data.service

/**
 * 摇奖器
 * 超级大乐透游戏规则
 * 超级大乐透基本投注是指从前区号码中任选五个号码，并从后区号码中任选两个号码的组合进行投注。
 * 其中，前区号码由01—35共三十五个号码组成，后区号码由01—12共十二个号码组成。
 */
class LotteryDrawMachine {

    companion object {
        /**
         * 投注5个前区号码
         */
        fun drawFrontArea(): List<Int> {
            return draw(frontArea(), 5)
        }

        /**
         * 投注2个后区号码
         */
        fun drawBackArea(): List<Int> {
            return draw(backArea(), 2)
        }

        private fun draw(balls: List<Int>, size: Int) = balls.shuffled().take(size).sorted()

        // 前区号码区
        private val frontArea = 1..35

        internal fun frontArea(): List<Int> {
            return frontArea.toList()
        }

        // 后区号码区
        private val backArea = 1..12

        internal fun backArea(): List<Int> {
            return backArea.toList()
        }
    }
}