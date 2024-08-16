package com.farez.simlasisupportecnhanter

import com.farez.simlasisupportecnhanter.fuzzy.FuzzyRule
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ValidasiData {
    @Test
    fun `validasi data output`() {
        var i = 0
        val list = getHpList()
        list.forEach { item ->
            val hpD = item[0] as Int
            val hpK = item[1] as Int
            val hpL = item[2] as Int
            FuzzyRule.setHP(hpD, hpK, hpL)
            val outputAngka = FuzzyRule.getOutputAngka()
            val outputKata = FuzzyRule.getOutputKata(outputAngka)
            println("$i $item expect:$outputKata $outputAngka")
            assertEquals(item[3], outputKata)
            i++
        }
    }
    fun getHpList() = listOf(
        listOf(4, 14, 24, "RECALL/MUNDUR"),
        listOf(5, 15, 25, "RECALL/MUNDUR"),
        listOf(7, 17, 27, "RECALL/MUNDUR"),
        listOf(10, 20, 30, "RECALL/MUNDUR"),
        listOf(11, 13, 15, "RECALL/MUNDUR"),
        listOf(13, 23, 33, "RECALL/MUNDUR"),
        listOf(19, 29, 39, "RECALL/MUNDUR"),
        listOf(20, 30, 40, "RECALL/MUNDUR"),
        listOf(25, 75, 25, "RECALL/MUNDUR"),
        listOf(28, 38, 48, "RECALL/MUNDUR"),

        listOf(34, 24, 14, "BANTU KAWAN"),

        listOf(35, 45, 55, "BANTU KAWAN"),
        listOf(39, 49, 59, "BANTU KAWAN"),
        listOf(41, 51, 61, "BANTU KAWAN"),
        listOf(44, 55, 66, "BANTU KAWAN"),

        listOf(45, 67, 89, "SERANG LAWAN"),
        listOf(48, 58, 68, "BANTU KAWAN"),
        listOf(50, 50, 50, "BANTU KAWAN"),
        listOf(53, 35, 66, "BANTU KAWAN"),
        listOf(66, 33, 99, "BANTU KAWAN"),
        listOf(66, 77, 88, "SERANG LAWAN"),
        listOf(70, 60, 50, "SERANG LAWAN"),
        listOf(72, 62, 52, "SERANG LAWAN"),
        listOf(77, 87, 97, "SERANG LAWAN"),
        listOf(78, 90, 12, "SERANG LAWAN"),
        listOf(90, 80, 70, "SERANG LAWAN"),
        listOf(91, 81, 71, "SERANG LAWAN"),
        listOf(92, 82, 72, "SERANG LAWAN"),
        listOf(99, 1, 50, "BANTU KAWAN"),
        listOf(99, 88, 77, "SERANG LAWAN")
    )
}