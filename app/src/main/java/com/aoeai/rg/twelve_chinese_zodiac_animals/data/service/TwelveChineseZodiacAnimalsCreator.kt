package com.aoeai.rg.twelve_chinese_zodiac_animals.data.service

class TwelveChineseZodiacAnimalsCreator  {

    companion object {

        fun randomList(count : Int): List<String> {
            return List(count) { random() }
        }

        private fun random(): String {
            val index = (0..11).random()
            return animals[index]
        }

        fun twelveChineseZodiacAnimals(): List<String> {
            return animals
        }

        private val animals = listOf(
            "🐭", "🐮", "🐯", "🐰", "🐲", "🐍", "🐴", "🐑", "🐵", "🐔", "🐶", "🐷"
        )
    }
}