package com.muhkhaled.wazzakrine.allahNames.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhkhaled.wazzakrine.R
import com.muhkhaled.wazzakrine.core.presentation.theme.Shapes
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme

@Composable
fun AllahNamesScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            painter = painterResource(id = R.drawable.allah_name_header_img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        HeaderHadeth(modifier = Modifier.offset(y = (-28).dp))
        AllahNamesGridList()
    }
}

@Composable
private fun HeaderHadeth(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
            text = "قال رسول الله ﷺ: ( إن لله تسعة وتسعين اسمًا لا\n" + "يحفظها أحد إلا دخل الجنة ) صدق رسول الله ﷺ",
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )
    }
}


@Composable
fun AllahNamesGridList(modifier: Modifier = Modifier, list: List<Int> = List(100) { 100 }) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        items(list.size) { item ->
            AllahName(number = item + 1)
        }
    }
}

@Composable
fun AllahName(modifier: Modifier = Modifier, number: Int) {
    // todo pass  parameter zeker custom data class with nama and number and id
    Card(
        modifier = modifier
            .padding(
                start = 8.dp,
                bottom = 8.dp
            )
            .wrapContentSize()
    ) {
        Column(
            Modifier
                .size(104.dp)
                .paint(
                    painter = painterResource(id = R.drawable.allah_name_item_pg),
                    contentScale = ContentScale.FillBounds
                ),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = number.toString())
            Text(modifier = Modifier.padding(10.dp), text = "AL rahman")
        }
    }
}

@Preview
@Composable
fun AllahNamesScreenPrev() {
    WazzakrineTheme {
        MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
            AllahNamesScreen()
        }
    }
}