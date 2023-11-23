package com.farez.simlasisupportecnhanter.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.farez.simlasisupportecnhanter.ui.navigation.MenuItem
import com.farez.simlasisupportecnhanter.ui.navigation.Screen

@Composable
fun HomeScreen(
    navController : NavHostController
) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        MenuItem.menuItemList.forEach{homeItem ->
            item {
                HomeItem(
                    title = homeItem.title,
                    deskripsi = homeItem.deskripsi,
                ) {
                    navController.navigate(homeItem.route)
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomePrev() {

}