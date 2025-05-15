package com.aoeai.rg.bagua.data.model

import kotlin.random.Random

internal class YaoRandom {

    companion object {
        fun next(): Int {
            return Random.nextInt(0, 2)
        }
    }
}