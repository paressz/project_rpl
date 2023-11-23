package com.farez.simlasisupportecnhanter.ui.screen.simulasi

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.farez.simlasisupportecnhanter.R
import com.farez.simlasisupportecnhanter.ui.theme.tiltNeon

@Composable
fun SimulasiResultDialog(
    hasilSimulasi: String,
    modifier: Modifier = Modifier,
    id: Int,
    showDialog: (Boolean) -> Unit
) {
    Dialog(onDismissRequest = { showDialog(false) }) {
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = RoundedCornerShape(24.dp),
            modifier = modifier
                .width(250.dp)
                .height(250.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TiltNeonText(text = "Hasil Simulasi", 24.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = id),
                    contentDescription = "Gambar $hasilSimulasi",
                )
                Spacer(modifier = Modifier.height(16.dp))
                TiltNeonText(text = hasilSimulasi, 21.sp)

            }
        }
    }
}

@Composable
private fun TiltNeonText(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = tiltNeon,
            fontSize = fontSize,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = modifier
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ResultPreview() {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        SimulasiResultDialog(
            hasilSimulasi = "Heal Kawan",
            id = R.drawable.output_heal,
            showDialog = {
                showDialog = it
            }
        )
    }
}