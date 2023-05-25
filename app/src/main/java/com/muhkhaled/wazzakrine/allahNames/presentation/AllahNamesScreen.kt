package com.muhkhaled.wazzakrine.allahNames.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhkhaled.wazzakrine.R

@Composable
fun AllahNamesScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.height(160.dp),
            painter = painterResource(id = R.drawable.allah_name_header_img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        HeaderHadeth(modifier = Modifier.offset(y = 28.dp))

    }
}


@Composable
private fun HeaderHadeth(modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        // todo
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
            text = "قال رسول الله ﷺ: ( إن لله تسعة وتسعين اسمًا لا\n" +
                    "يحفظها أحد إلا دخل الجنة ) صدق رسول الله ﷺ",
            fontSize = 14.sp
        )
    }
}


@Composable
fun AllahNamesGridList(list: List<Int> = List(1){100}) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)){
    }
}