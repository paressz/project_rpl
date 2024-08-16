package com.farez.simlasisupportecnhanter.fuzzy
import android.util.Log
import java.text.DecimalFormat

object MembershipFunction {

//    Mencari membership function untuk indikator low/rendah
//    memeriksa nilai hp, jika hp < 35 maka lakukan perhitungan
//    jika lebih dari 35 maka mengembalikan 0
    fun memLow(hp: Int): Double {
        val hp = hp.toDouble()
        return if (hp < 35 && hp >= 0) {
            var alpre = (35 - hp) / (35-0)
            val df = DecimalFormat("#.##")
            alpre = df.format(alpre).toDouble()
            alpre
        }
        else if (hp < 0) 1.0
        else 0.0
    }


//    Mencari membership function untuk indikator Medium/Menengah
//    memeriksa nilai hp, jika
//    hp >= 35 dan hp <= 50
//    atau
//    hp > 50 dan hp <= 65
//    jika nilai hp < 35 atau hp > 65 maka mengembalikan 0
    fun memMed(hp : Int) : Double {
        val hp = hp.toDouble()
        if(hp in 33.0..50.0) {
            var alpre = (hp-33)/(50-33)
            val df = DecimalFormat("#.##")
            alpre = df.format(alpre).toDouble()
            return alpre
        }
        else if(hp > 50 && hp <= 67) {
            var alpre = (67 - hp)/(67-50)
            val df = DecimalFormat("#.##")
            alpre = df.format(alpre).toDouble()
            return alpre
        }
        else return 0.0
    }


//    Mencari membership function untuk indikator high/tinggi
//    jika nilai hp > 65 maka akan dilakukan perhitungan
//    jika nilai hp < 65 maka akan mengembalikan 0
    fun memHigh(hp : Int) : Double {
        val hp = hp.toDouble()
        if(hp > 65 && hp <= 100) {
            var alpre = (hp-65)/(100-65)
            val df = DecimalFormat("#.##")
            alpre = df.format(alpre).toDouble()
            return alpre
        }
        else if (hp > 100) return 1.0
        else return 0.0
    }

}