package com.example.tugasakhir.view.screen

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.model.dummyMainan
import com.example.tugasakhir.model.dummySepeda
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.GrayLight500
import com.example.tugasakhir.ui.theme.GreenColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.components.HistoryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
){
    val tabTitles = listOf("Sewa", "Point")
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    Column {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                navigationIconContentColor = MaterialTheme.colorScheme.primary
            ),
            title = {
                Text(
                    text = stringResource(R.string.screen_history),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,),
                    modifier = Modifier.padding(start = 8.dp)
                )
            })
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.LightGray)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(55.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            TabLayout(
                tabTitles = tabTitles,
                selectedTabIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it }
            )
        }
        when (selectedTabIndex) {
            0 ->Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(1f)){
                HistorySewaContent() }
            1 ->Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(1f)){
                HistoryPointContent()}
        }
    }
}


@Composable
private fun TabLayout(
    modifier: Modifier = Modifier,
    tabTitles: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
){
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier
            .clip(RoundedCornerShape(15))
            .height(35.dp)
            .width(250.dp),
        indicator = {tabPositions: List<TabPosition> -> Box {} }
        ) {
        tabTitles.forEachIndexed { index, title ->  var selected = selectedTabIndex == index
        Tab(
            modifier = if (selected) Modifier
                .clip(RoundedCornerShape(20))
                .background(BlueColor500)
            else Modifier
                .clip(RoundedCornerShape(20))
                .background(Color.White),
            text = { Text(text= title, color = if (selected) Color.White else Color.Black)  },
            selected = selected,
            onClick = {onTabSelected(index)}
        )
        }
    }
}

@Composable
fun HistorySewaContent(){

    HistoryItem(
        image = R.drawable.sepeda1 ,
        title = "Sepeda Listrik",
        type = "Biru",
        information = "13 April 2023 - 09.23" ,
        status = "Selesai" )
}

@Composable
fun HistoryPointContent(
    modifier: Modifier = Modifier,
){

    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(GrayLight500)
            .padding(18.dp)
    ) {
        Text(
            letterSpacing = 0.25.sp,
            text = buildAnnotatedString {
                append("Tukar point")
                withStyle(style = SpanStyle(GreenColor500)  ){append("100")}},
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            ))
        Text(
            text = "13 April 2024 - 09.05",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
            ))
    }
    Spacer(modifier = modifier.height(10.dp))
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(GrayLight500)
            .padding(18.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append("Point bertambah")
                withStyle(style = SpanStyle(BlueColor500)){append("100")}},
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            ))
        Text(
            text = "13 April 2024 - 09.05",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
            ))
    }
}

@Preview
@Composable
private fun TabLayoutrPreview() {
    TugasAkhirTheme {
        TabLayout(
            tabTitles = listOf("Sewa", "Point"),
            selectedTabIndex = 0,
            onTabSelected = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    TugasAkhirTheme{
        HistoryScreen()
    }
}