package com.farez.simlasisupportecnhanter.fuzzy

import android.util.Log
import com.farez.simlasisupportecnhanter.data.model.SugenoData
import java.text.DecimalFormat
import kotlin.math.*

object FuzzyRule {
    var hpDiri = 0
    var hpKawan = 0
    var hpLawan = 0

    fun setHP(hpDiri: Int, hpKawan: Int, hpLawan : Int) {
        this.hpDiri = hpDiri
        this.hpKawan = hpKawan
        this.hpLawan = hpLawan
    }

    fun getOutputAngka() : Double{
        val data : ArrayList<SugenoData> = ArrayList()
        //untuk rule dengan output =  1
        data.add(rule1()); data.add(rule2()); data.add(rule3())
        data.add(rule4()); data.add(rule5()); data.add(rule6())
        data.add(rule7()); data.add(rule8()); data.add(rule9())
        //untuk rule dengan output =  2
        data.add(rule10()); data.add(rule11()); data.add(rule12())
        data.add(rule13()); data.add(rule14()); data.add(rule15())
        data.add(rule16()); data.add(rule17()); data.add(rule18())
        //untuk rule dengan output =  3
        data.add(rule19()); data.add(rule20()); data.add(rule21())
        data.add(rule22()); data.add(rule23()); data.add(rule24())
        data.add(rule25()); data.add(rule26()); data.add(rule27())
        //total alpha predikat * z
        var x = 0.0
        //total alpha predikat
        var y = 0.0
        /*
        iterasi list SugenoData untuk mendapatkan
        rata-rata dari setiap alpha predikat dan z
        kemudian digunakan untuk menghitung output
        */
        data.forEach {
            x += (it.alphaPredikat * it.z)
            y += it.alphaPredikat
        }
        val df = DecimalFormat("#.##")
        val output = df.format(x/y).toDouble()
        Log.d("OUTPUT SUGENO ANGKA", "getOutputAngka: $output")
        return output
    }
    fun getOutputKata(output : Double) : String {
        if(output <= 1) return "SERANG LAWAN"
        else if (output >= 2 && output < 3) return "BANTU KAWAN"
        else return "RECALL/MUNDUR"
    }
    fun rule1() : SugenoData {
        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)
        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule2() : SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule3() : SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule4(): SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule5(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule6(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule7(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule8(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule9(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 1)
        return data
    }
    fun rule10(): SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule11(): SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule12(): SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule13(): SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule14(): SugenoData {

        val memDiri = MembershipFunction.memMed(hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule15(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule16(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule17(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule18(): SugenoData {

        val memDiri = MembershipFunction.memHigh(hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 2)
        return data
    }
    fun rule19(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule20(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule21(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memLow(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule22(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule23(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule24(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memMed(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule25(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memLow(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule26(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memMed(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
    fun rule27(): SugenoData {

        val memDiri = MembershipFunction.memLow (hpDiri)
        val memKawan = MembershipFunction.memHigh(hpKawan)
        val memLawan = MembershipFunction.memHigh(hpLawan)

        var alpre = min(memDiri, memKawan)
        alpre = min(alpre, memLawan)
        val data = SugenoData(alphaPredikat = alpre, z = 3)
        return data
    }
}