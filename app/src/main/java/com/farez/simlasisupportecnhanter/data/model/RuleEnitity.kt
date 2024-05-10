package com.farez.simlasisupportecnhanter.data.model

data class RuleEnitity(val hpDiri : Indikator, val hpKawan : Indikator, val hpLawan : Indikator, val output : String) {
    companion object {
        private val ruleEntities = arrayListOf(
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.LOW, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.HIGH, hpLawan = Indikator.LOW, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.HIGH, hpLawan = Indikator.MEDIUM, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.HIGH, hpLawan = Indikator.HIGH, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.HIGH, hpLawan = Indikator.HIGH, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.HIGH, hpLawan = Indikator.HIGH, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.LOW, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.MEDIUM, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.HIGH, hpLawan = Indikator.LOW, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.HIGH, hpLawan = Indikator.MEDIUM, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.HIGH, hpLawan = Indikator.HIGH, output = "SERANG LAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.LOW, hpLawan = Indikator.LOW, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.LOW, hpLawan = Indikator.MEDIUM, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.LOW, hpLawan = Indikator.HIGH, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.MEDIUM, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.MEDIUM, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.HIGH, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.LOW, hpLawan = Indikator.LOW, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.LOW, hpLawan = Indikator.MEDIUM, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.LOW, hpLawan = Indikator.HIGH, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.HIGH, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.HIGH, output = "LINDUNGI KAWAN"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.LOW, hpLawan = Indikator.LOW, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.LOW, hpLawan = Indikator.MEDIUM, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.LOW, hpLawan = Indikator.HIGH, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.LOW, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.MEDIUM, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.MEDIUM, hpLawan = Indikator.HIGH, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.HIGH, hpLawan = Indikator.LOW, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.HIGH, hpLawan = Indikator.MEDIUM, output = "RECALL/MUNDUR"),
            RuleEnitity(hpDiri = Indikator.LOW, hpKawan = Indikator.HIGH, hpLawan = Indikator.HIGH, output = "RECALL/MUNDUR")
        )
        fun getRuleEntities() : List<RuleEnitity> = ruleEntities
    }
}

