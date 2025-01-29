package com.aoeai.rg.number.data

import kotlin.random.Random

class NumberCreator {

        companion object {

            fun randomList(count : Int): List<Int> {
                return List(count) { random() }
            }

            private fun random(): Int {
                return Random.nextInt(0, 10)
            }
        }
}