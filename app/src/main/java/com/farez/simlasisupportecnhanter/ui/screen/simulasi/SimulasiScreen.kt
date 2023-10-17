package com.farez.simlasisupportecnhanter.ui.screen.simulasi

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.farez.simlasisupportecnhanter.ui.theme.BlueMain
import com.farez.simlasisupportecnhanter.ui.theme.tiltNeon

@Preview
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
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
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
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BlueMain
            ),
            onClick = {
                if (selfHp.isEmpty() || allyHp.isEmpty() || enemyHp.isEmpty()) {
                    Toast.makeText(context, "Masih ada bagian yang kosong", Toast.LENGTH_SHORT)
                        .show()
                } else if (Integer.parseInt(selfHp) > 100 || Integer.parseInt(allyHp) > 100 || Integer.parseInt(enemyHp) > 100) {
                    Toast.makeText(context, "Nilai harus kurang dari 100", Toast.LENGTH_SHORT)
                        .show()
                }
            },
        ) {
            Text(
                text = "Tampilkan Hasil",
                style = TextStyle(
                    fontFamily = tiltNeon,
                    fontSize = 16.sp
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
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = tiltNeon,
                    fontSize = 16.sp
                )
            )
        },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = BlueMain,
            focusedLabelColor = BlueMain,
            cursorColor = BlueMain
        ),
    )
}