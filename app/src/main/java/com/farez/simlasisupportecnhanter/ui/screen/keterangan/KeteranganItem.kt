@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.farez.simlasisupportecnhanter.ui.screen.keterangan

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farez.simlasisupportecnhanter.R


@Composable
fun KeteranganItem(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    drawableId: Int,
) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        onClick = { isExpanded = !isExpanded }

    ) {
        AnimatedVisibility(
            visible = !isExpanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            KeteranganMinimized(
                title = title,
                desc = desc,
                drawableId = drawableId,
                modifier = modifier,
            )
        }
        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            KeteranganExpanded(
                title = title,
                desc = desc,
                drawableId = drawableId,
                modifier = modifier,
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeteranganExpanded(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    drawableId: Int,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment
            .CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = title,
            modifier = Modifier
                .size(150.dp)
                .padding(top = 16.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        CustomizedText(
            text = desc,
            modifier = Modifier.align(Alignment.Start)
        )
        CustomizedText(
            text = "Nilai Minimal : 0",
            modifier = Modifier.align(Alignment.Start)
        )
        CustomizedText(
            text = "Nilai Maksimal : 100",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start)
        )
    }
}

@Composable
private fun CustomizedText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
}

@Composable
fun KeteranganMinimized(
    title: String,
    desc: String,
    drawableId: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = title,
            modifier = Modifier
                .size(64.dp)
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = desc,
                modifier = Modifier
                    .padding(top = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PrevKetItem() {
    KeteranganItem(
        title = "HP Kawan",
        desc = "Nilai HP Kawan yang akan disimulasikan",
        drawableId = R.drawable.hp_ally
    )
}
