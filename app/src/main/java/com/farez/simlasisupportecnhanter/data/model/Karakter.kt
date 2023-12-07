package com.farez.simlasisupportecnhanter.data.model

interface Karakter {
    var hp : Int
    var indikator : Indikator

    fun setIndikator(hp : Int) : Indikator
}
