package com.farez.simlasisupportecnhanter.ui.screen.rules

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farez.simlasisupportecnhanter.R
import com.farez.simlasisupportecnhanter.data.model.RuleEnitity

@Composable
fun RuleScreen(modifier : Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RuleEnitity.getRuleEntities().forEachIndexed {index, ruleEnitity ->
            item {
                RuleItem(
                    title = "Rule ${index + 1}",
                    content = "hp kawan : ${ruleEnitity.hpKawan.name}".uppercase() +
                            "\n" +
                            "hp diri : ${ruleEnitity.hpDiri.name}".uppercase() +
                            "\n" +
                            "hp lawan : ${ruleEnitity.hpLawan.name}".uppercase() +
                            "\n" +
                            "output : ${ruleEnitity.output}".uppercase()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RuleItem(title : String, content : String, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        onClick = {isExpanded = !isExpanded}
    ) {
        AnimatedVisibility(visible = isExpanded, enter = expandVertically(), exit = shrinkVertically()) {
            ExpandedRuleItem(title, content, modifier)
        }
        AnimatedVisibility(visible = !isExpanded, enter = expandVertically(), exit = shrinkVertically()) {
            CollapsedRuleItem(title, modifier)
        }
    }
}

@Composable
private fun CollapsedRuleItem(title : String, modifier: Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.info_circle),
            contentDescription = title,
            modifier = modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun ExpandedRuleItem(title : String, content : String, modifier: Modifier) {
    Column {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.info_circle),
                contentDescription = title,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = content)
        }
    }
}