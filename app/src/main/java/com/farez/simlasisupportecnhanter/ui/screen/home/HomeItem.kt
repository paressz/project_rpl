package com.farez.simlasisupportecnhanter.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farez.simlasisupportecnhanter.ui.theme.BlueMain
import com.farez.simlasisupportecnhanter.ui.theme.tiltNeon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeItem(
    title : String,
    deskripsi : String,
    modifier: Modifier = Modifier,
    onClick : () -> Unit
) {
    Card(
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(110.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        onClick = onClick
    ) {
            Text(
                text = title,
                modifier = modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = tiltNeon,
                    fontSize = 18.sp
                )
            )
            Text(
                text = deskripsi,
                modifier = modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                style = TextStyle(
                    fontFamily = tiltNeon,
                    fontSize = 16.sp
                )
            )
    }
}

@Preview(
    showBackground = true,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE
)
@Composable
private fun ItemPreview() {
    val context = LocalContext.current
    HomeItem(title = "Mulai Simulasi", deskripsi = "Mulai simulasi perilaku kecerdasan buatan") {
        Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
    }
}
