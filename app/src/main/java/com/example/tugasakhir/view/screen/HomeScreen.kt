package com.example.tugasakhir.view.screen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tugasakhir.R
import com.example.tugasakhir.model.Menu
import com.example.tugasakhir.model.dummyMenu
import com.example.tugasakhir.view.components.Card
import com.example.tugasakhir.view.components.HomeSegment
import com.example.tugasakhir.view.components.MenuItem
import com.example.tugasakhir.view.components.Spinner


@Composable
fun HomeScreen(
    navigateToWheelspinScreen: () -> Unit = {},
    navigateToItemScreen: () -> Unit = {}
){
    HomeContent(
        navigateToWheelspinScreen = navigateToWheelspinScreen,
        navigateToItemScreen = navigateToItemScreen
    )
}

@Composable
fun Banner(
    modifier: Modifier=Modifier,
){
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "Banner Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(18.dp)
            .clickable(onClick = { })
            .height(250.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    navigateToItemScreen: () -> Unit = {}
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)) {
        MenuItem(
            navigateToItemScreen = navigateToItemScreen,
            menu = com.example.tugasakhir.model.Menu(
                image = R.drawable.menu1,
                title = "Sepeda Listrik"
            )
        )
        MenuItem(
            navigateToItemScreen = navigateToItemScreen,
            menu = com.example.tugasakhir.model.Menu(
                image = R.drawable.menu2,
                title = "Mainan Anak"
            )
        )
    }
}

@Composable
fun HomeContent(
    navigateToWheelspinScreen: () -> Unit = {},
    navigateToItemScreen: () -> Unit = {}
){
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState()))
    {
        Banner()
        Card()
        HomeSegment(
            title = stringResource(id = R.string.section_menu),
            content = { Menu(navigateToItemScreen=navigateToItemScreen) })
        Spinner(
            image = R.drawable.spinner,
            title = "Spin the Wheel",
            desc = "Dapatkan tambahan waktu bermain dengan menukarkan point",
            navigateToWheelspinScreen = navigateToWheelspinScreen
        )
    }
}

