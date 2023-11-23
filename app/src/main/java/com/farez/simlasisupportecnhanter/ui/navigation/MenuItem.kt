package com.farez.simlasisupportecnhanter.ui.navigation

data class MenuItem(val title: String, var deskripsi: String, var route: String) {
    companion object {
        val menuItemList = listOf(
            MenuItem(
                "Mulai Simulasi",
                "Mulai simulasi perilaku kecerdasan buatan",
                Screen.Simulasi.route
            ),
            MenuItem("Daftar Rule", "Tampilkan daftar rule untuk simulasi", Screen.Rule.route),
            MenuItem("Keterangan", "Tampilkan informasi tentang aplikasi", Screen.Keterangan.route)
        )
    }
}