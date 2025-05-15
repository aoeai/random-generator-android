package com.aoeai.rg.double_color_ball.data.service

/**
 * 摇奖器
 * 双色球投注区分为红色球号码区和蓝色球号码区，红色球号码区由1-33共三十三个号码组成，
 * 蓝色球号码区由1-16共十六个号码组成。投注时选择6个红色球号码和1个蓝色球号码组成一注进行单式投注。
 */
class LotteryDrawMachine {

    companion object {

        /**
         * 投注6个红球
         */
        fun drawRedBalls(): List<Int> {
            return draw(redBallArea(), 6)
        }

        /**
         * 投注1个蓝球
         */
        fun drawBlueBall(): Int {
            return draw(blueBallArea(), 1).first()
        }

        private fun draw(balls: List<Int>, size: Int) = balls.shuffled().take(size).sorted()

        // 红球号码区
        private val redBallArea = 1..33

        internal fun redBallArea(): List<Int> {
            return redBallArea.toList()
        }

        // 蓝球号码区
        private val blueBallArea = 1..16

        internal fun blueBallArea(): List<Int> {
            return blueBallArea.toList()
        }
    }
}