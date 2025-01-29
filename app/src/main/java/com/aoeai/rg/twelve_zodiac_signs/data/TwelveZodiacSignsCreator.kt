package com.aoeai.rg.twelve_zodiac_signs.data

import com.aoeai.rg.R

class TwelveZodiacSignsCreator {

        companion object {

            fun randomImageId(): Int {
                return zodiacImageIds.random()
            }

            private val zodiacImageIds = listOf(
                R.drawable.twelve_zodiac_aries,
                R.drawable.twelve_zodiac_taurus,
                R.drawable.twelve_zodiac_gemini,
                R.drawable.twelve_zodiac_cancer,
                R.drawable.twelve_zodiac_leo,
                R.drawable.twelve_zodiac_virgo,
                R.drawable.twelve_zodiac_libra,
                R.drawable.twelve_zodiac_scorpio,
                R.drawable.twelve_zodiac_sagittarius,
                R.drawable.twelve_zodiac_capricorn,
                R.drawable.twelve_zodiac_aquarius,
                R.drawable.twelve_zodiac_pisces
            )
        }
}