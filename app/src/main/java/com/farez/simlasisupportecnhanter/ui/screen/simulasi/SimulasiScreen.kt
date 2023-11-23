package com.farez.simlasisupportecnhanter.ui.screen.simulasi

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.farez.simlasisupportecnhanter.R
import com.farez.simlasisupportecnhanter.ui.theme.BlueMain
import com.farez.simlasisupportecnhanter.ui.theme.tiltNeon

@Preview(showBackground = true)
@Composable
private fun preview() {
    SimulasiScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimulasiScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var enemyHp by remember { mutableStateOf("") }
    var selfHp by remember { mutableStateOf("") }
    var allyHp by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        SimulasiResultDialog(
            hasilSimulasi = "Sample Hasil",
            id = R.drawable.output_heal,
            showDialog = {
                showDialog = it
            })
    }
    Column (
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomizedOutlinedTextField(
            value = selfHp,
            onValueChanged = { input -> if (input.isDigitsOnly()) selfHp = input },
            label = "HP Diri"
        )
        CustomizedOutlinedTextField(
            value = allyHp,
            onValueChanged = { input -> if (input.isDigitsOnly()) allyHp = input },
            label = "HP Kawan"
        )
        CustomizedOutlinedTextField(
            value = enemyHp,
            onValueChanged = { input -> if (input.isDigitsOnly()) enemyHp = input },
            label = "HP Lawan"
        )
        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            onClick = {
                if (selfHp.isEmpty() || allyHp.isEmpty() || enemyHp.isEmpty()) {
                    Toast.makeText(context, "Masih ada bagian yang kosong", Toast.LENGTH_SHORT)
                        .show()
                } else if (Integer.parseInt(selfHp) > 100 || Integer.parseInt(allyHp) > 100 || Integer.parseInt(enemyHp) > 100) {
                    Toast.makeText(context, "Nilai harus kurang dari 100", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    showDialog = true
                }
            },
        ) {
            Text(
                text = "Tampilkan Hasil",
                style = TextStyle(
                    fontFamily = tiltNeon,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizedOutlinedTextField(
    value : String,
    onValueChanged: (String) -> Unit,
    label : String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(68.dp),
        label = {
            TiltNeonText(text = label)
        },
        shape = RoundedCornerShape(8.dp),
    )
}

@Composable
private fun TiltNeonText(
    text : String,
    modifier: Modifier = Modifier
    ) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = tiltNeon,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        modifier = modifier
    )
}