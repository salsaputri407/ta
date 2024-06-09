package com.example.tugasakhir.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasakhir.R
import com.example.tugasakhir.model.Barang
import com.example.tugasakhir.model.dummyMainan
import com.example.tugasakhir.model.dummySepeda
import com.example.tugasakhir.ui.theme.BlueColor500
import com.example.tugasakhir.ui.theme.TugasAkhirTheme
import com.example.tugasakhir.view.components.ItemBarang

@Composable
fun ItemScreen(
    modifier: Modifier = Modifier,
    navigateToCartItemScreen : () -> Unit,
    navigateToDetailItemScreen : (Long, Int, String) -> Unit
) {
    val tabTitles = listOf("Sepeda Listrik", "Mainan Anak")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        TopAppBar(navigateToCartItemScreen=navigateToCartItemScreen)
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
                .padding(vertical = 15.dp, horizontal = 20.dp)
        ) {
            TabLayout(
                tabTitles = tabTitles,
                selectedTabIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it }
            )
        }
        when (selectedTabIndex) {
            0 -> BarangContent(listBarang = dummySepeda, navigateToDetailBarangScreen = navigateToDetailItemScreen)
            1 -> BarangContent(listBarang = dummyMainan, navigateToDetailBarangScreen = navigateToDetailItemScreen)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar(
    modifier: Modifier = Modifier,
    navigateToCartItemScreen : () -> Unit,) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(
                text = stringResource(R.string.screen_barang),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,),
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        actions = {
            IconButton(onClick = { navigateToCartItemScreen()}) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Keranjang",
                    tint = BlueColor500
                )
            }
        }
    )
}

@Composable
fun TabLayout(
    modifier: Modifier = Modifier,
    tabTitles: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Row {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.clip(RoundedCornerShape(25)),
            indicator = {tabPositions: List<TabPosition> -> Box {} }
        ) {
            tabTitles.forEachIndexed { index, title ->
                var selected = selectedTabIndex == index
                Tab(
                    modifier = if (selected) Modifier
                        .clip(RoundedCornerShape(25))
                        .background(BlueColor500)
                    else
                        Modifier
                            .clip(RoundedCornerShape(25))
                            .background(Color.White),
                    text = { Text(text= title, color = if (selected) Color.White else Color.Black)   },
                    selected = selected,
                    onClick = { onTabSelected(index) })
            }
        }
    }
}

@Composable
fun BarangContent(
    modifier: Modifier = Modifier,
    listBarang: List<Barang>,
    navigateToDetailBarangScreen : (Long, Int, String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(175.dp),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
    ) {
        items(listBarang, key = { it.title }) { barang ->
            ItemBarang(barang = barang, navigateToDetailBarangScreen = navigateToDetailBarangScreen)
        }
    }
}

//@Preview
//@Composable
//private fun TitleBarPreview() {
//    TugasAkhirTheme {
//        TopAppBar()
//    }
//}

@Preview
@Composable
private fun TabLayoutrPreview() {
    TugasAkhirTheme {
        TabLayout(
            tabTitles = listOf("Sepeda Listrik", "Mainan Anak"),
            selectedTabIndex = 0,
            onTabSelected = {}
        )
    }
}