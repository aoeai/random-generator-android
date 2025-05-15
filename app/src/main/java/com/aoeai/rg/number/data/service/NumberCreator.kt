package com.aoeai.rg.number.data.service

import kotlin.random.Random

class NumberCreator {

        companion object {

            fun randomList(count : Int): List<Int> {
                return List(count) { random() }
            }

            private fun random(): Int {
                return Random.Default.nextInt(0, 10)
            }
        }
}