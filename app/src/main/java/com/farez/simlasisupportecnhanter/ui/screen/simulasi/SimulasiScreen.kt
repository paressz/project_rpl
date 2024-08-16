package com.farez.simlasisupportecnhanter.ui.screen.simulasi

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.text.isDigitsOnly
import com.farez.simlasisupportecnhanter.R
import com.farez.simlasisupportecnhanter.fuzzy.FuzzyRule
import com.farez.simlasisupportecnhanter.ui.theme.tiltNeon
import java.io.FileOutputStream

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
    var output by remember { mutableStateOf(100.0) }
    val createPdf =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.CreateDocument("application/pdf")) { result ->
            val uri = result.toString()
            generatePdf(context, uri, selfHp, allyHp, enemyHp, output)
            Log.d("URIR", "SimulasiScreen: ${result.toString()}")
        }
    if (showDialog) {
        SimulasiResultDialog(
            hasilSimulasi = FuzzyRule.getOutputKata(output),
            id = if (output <= 1) R.drawable.sword_duotone_svgrepo_com
            else if (output >= 2 && output < 3) R.drawable.muscle_svgrepo_com
            else R.drawable.run_sports_runner_svgrepo_com,
            onLaporanClick = { createPdf.launch("HasilSimulasi.pdf") },
        ) {
            showDialog = it
        }
    }
    Column(
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
                } else if (Integer.parseInt(selfHp) > 100 || Integer.parseInt(allyHp) > 100 || Integer.parseInt(
                        enemyHp
                    ) > 100
                ) {
                    Toast.makeText(context, "Nilai harus kurang dari 100", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    showDialog = true
                    FuzzyRule.setHP(selfHp.toInt(), allyHp.toInt(), enemyHp.toInt())
                    output = FuzzyRule.getOutputAngka()
                    Log.d("OUTPUT KATA", "SimulasiScreen: ${FuzzyRule.getOutputKata(output)}")
                    //generatePdf(context, output, uri)
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

fun generatePdf(
    context: Context,
    uri: String,
    self: String,
    ally: String,
    enemy: String,
    output: Double
) {
    val hasilSimulasi = FuzzyRule.getOutputKata(output)
    val idGambarHasil = if (output <= 1) R.drawable.sword_duotone_svgrepo_com
    else if (output >= 2 && output < 3) R.drawable.muscle_svgrepo_com
    else R.drawable.run_sports_runner_svgrepo_com
    //Menentukan tinggi dan lebar dari dokumen
    val height = 450
    val width = 360/*
    * convert drawable berupa svg menjadi bitmap
    * kemudian diresize
    * */
    val bmp = ContextCompat.getDrawable(context, idGambarHasil)!!.toBitmap()
    val scaledBmp = Bitmap.createScaledBitmap(bmp, 135, 135, false)
    val pdfDocument = PdfDocument()
    val paint = Paint()
    val text = Paint()
    val pageInfo: PdfDocument.PageInfo? = PdfDocument.PageInfo.Builder(width, height, 1).create()
    val startPage = pdfDocument.startPage(pageInfo)
    val c = startPage.canvas
    text.apply {
        typeface = (Typeface.create(Typeface.DEFAULT, Typeface.NORMAL))
        textSize = 20f
        color = Color.Black.toArgb()
        textAlign = Paint.Align.CENTER
    }
    // teks Jdudul
    c.drawText("LAPORAN HASIL SIMULASI", 180f, 40f, text)/*
    * ubah alignment menjadi rata kiri dan
    * menambahkan teks variabel input
    * */
    text.apply {
        textAlign = Paint.Align.LEFT
        textSize = 16f
    }
    c.drawText("Nilai HP Diri", 22f, 88f, text)
    c.drawText("Nilai HP Kawan", 22f, 120f, text)
    c.drawText("Nilai HP Lawan", 22f, 153f, text)/*
    * ganti alignment menjadi rata kanan dan
    * menambahkan teks nilai dari variabel input
    */
    text.textAlign = Paint.Align.RIGHT
    c.drawText(self, 338f, 88f, text)
    c.drawText(ally, 338f, 120f, text)
    c.drawText(enemy, 338f, 153f, text)/*
    * memasukkan teks dan gambar hasil simulasi
    * kemudian finishPage dipanggil untuk
    * memberitahu bahwa halaman telah selesai dibuat
    */
    text.textAlign = Paint.Align.CENTER
    c.drawText("Aksi Kecerdasan Buatan", 180f, 215f, text)
    c.drawBitmap(scaledBmp, 100f, 240f, paint)
    c.drawText(hasilSimulasi, 180f, 418f, text)
    pdfDocument.finishPage(startPage)

    /*
    * Read file sesuai uri menggunakan ParcelFileDescriptor,
    * kemudian write pdf yang dibuat ke dalam file tersebut.
    * ParcelFileDescriptor digunakan untuk berinteraksi dengan suatu file
    * dengan cara yang aman di sistem android
    */
    try {
        val fileDescriptor = context.contentResolver.openFileDescriptor(Uri.parse(uri), "w")
        fileDescriptor?.use { pdfDocument.writeTo(FileOutputStream(it.fileDescriptor)) }
        fileDescriptor?.close()
        Toast.makeText(context, "File Laporan berhasil dibuat", Toast.LENGTH_SHORT).show()

    } catch (e: Exception) {
        Log.d("PDF GENERATE", "generatePdf: ${e.message}")
        Toast.makeText(context, "File Laporan gagal dibuat", Toast.LENGTH_SHORT).show()
    }
    pdfDocument.close()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizedOutlinedTextField(
    value: String, onValueChanged: (String) -> Unit, label: String, modifier: Modifier = Modifier
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
    text: String, modifier: Modifier = Modifier
) {
    Text(
        text = text, style = TextStyle(
            fontFamily = tiltNeon,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        ), modifier = modifier
    )
}