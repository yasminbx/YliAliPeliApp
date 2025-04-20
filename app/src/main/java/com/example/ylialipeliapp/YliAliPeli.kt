package com.example.ylialipeliapp


class YliAliPeli(val low: Int, val high: Int) {
    val secret = (low..high).random()
    var guesses = 0

    fun arvaa(arvaus: Int): Arvaustulos {
        guesses++
        return when {
            arvaus > secret -> Arvaustulos.High
            arvaus < secret -> Arvaustulos.Low
            else -> Arvaustulos.Hit
        }
    }

    enum class Arvaustulos {
        Low, Hit, High
    }
}