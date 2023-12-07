package com.farez.simlasisupportecnhanter.data.model

class KarakterImpl(override var hp: Int) : Karakter {
    override lateinit var indikator: Indikator

    override fun setIndikator(hp: Int): Indikator {
        TODO("Not yet implemented")
    }
}