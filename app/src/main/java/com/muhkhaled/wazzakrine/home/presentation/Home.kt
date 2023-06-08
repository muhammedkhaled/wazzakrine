package com.muhkhaled.wazzakrine.home.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhkhaled.wazzakrine.R
import com.muhkhaled.wazzakrine.core.presentation.theme.Shapes
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        HomeFirstUiPart()
        AllPrayersTime(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp))
        val state = rememberLazyListState()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            state = state,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
        ) {
            item {
                AzkarItem(
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 6.dp),
                    title = "Evening Azkar",
                    backGround = R.drawable.evenning_azkar_bg
                )
            }
            item {
                AzkarItem(
                    modifier = Modifier.padding(top = 8.dp, start = 6.dp, end = 6.dp),
                    title = "Evening Azkar",
                    backGround = R.drawable.evenning_azkar_bg
                )
            }
            item {
                AzkarItem(
                    modifier = Modifier.padding(top = 8.dp, start = 6.dp, end = 8.dp),
                    title = "Evening Azkar",
                    backGround = R.drawable.evenning_azkar_bg
                )
            }
        }

    }
}

@Preview
@Composable
fun HomeScreenPrev() {
    WazzakrineTheme {
        MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
            Surface(color = MaterialTheme.colors.background) {
                HomeScreen()
            }
        }

    }
}


@Composable
fun HomeFirstUiPart() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(140.dp)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NextAzanCard(modifier = Modifier.wrapContentHeight().width(160.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DateCard(modifier = Modifier.padding(start = 8.dp))
                CurrentPlaceAndTempCard(modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}


@Composable
fun DateCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier.wrapContentSize()) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row(
                modifier = Modifier
                    .width(160.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_hijri_date),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "8 Ramadan 1442 AH",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .width(160.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_calender),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "Sunday, 5 May",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}

@Preview
@Composable
fun DateCardPrev() {
    DateCard()
}


@Composable
fun CurrentPlaceAndTempCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier.wrapContentSize()) {
        Column(modifier = Modifier.wrapContentSize()) {
            Row(
                modifier = Modifier
                    .width(160.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "Cairo, Egypt",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            Row(
                modifier = Modifier
                    .width(160.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_temperature),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "38 c",
                    textAlign = TextAlign.Start,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}

@Preview
@Composable
fun CurrentPlaceAndTempPrev() {
    CurrentPlaceAndTempCard()
}

@Composable
fun NextAzanCard(modifier: Modifier = Modifier, columnModifier: Modifier = Modifier) {
    Card(
        backgroundColor = Color.Transparent,
        modifier = modifier
    ) {
        Column(
            modifier = columnModifier
                .paint(
                    painter = painterResource(id = R.drawable.next_azan),
                    contentScale = ContentScale.FillBounds
                )
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "Next azan Maghrap",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier.padding(top = 18.dp),
                text = "05:30 AM",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(top = 18.dp, bottom = 8.dp),
                text = "Will start in 1 hour 52 minutes",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                minLines = 2,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun NextAzanCardPreview() {
    NextAzanCard()
}

@Composable
fun AllPrayersTime(modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // todo make string res arabic and en
            SinglePrayer(prayerName = "Fajer", prayerTime = "05:15 AM")
            SinglePrayer(prayerName = "Shroq", prayerTime = "06:15 AM")
            SinglePrayer(prayerName = "Duhr", prayerTime = "12:15 PM")
            SinglePrayer(prayerName = "Aser", prayerTime = "03:15 PM")
            SinglePrayer(isItNextPrayer = true, prayerName = "Maghrib", prayerTime = "05:15 PM")
            SinglePrayer(prayerName = "Asha", prayerTime = "07:15 PM")
        }
    }
}

@Preview
@Composable
fun AllPrayersTimePrev() {
    AllPrayersTime()
}

@Composable
fun SinglePrayer(isItNextPrayer: Boolean = false, prayerName: String, prayerTime: String) {
    val selectedTextColor = if (isItNextPrayer) Color.White else MaterialTheme.colors.onBackground
    Card(
        elevation = 0.dp,
        backgroundColor =
        if (isItNextPrayer) MaterialTheme.colors.primary else MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier.wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp, start = 4.dp, end = 4.dp),
                text = prayerName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = selectedTextColor
            )
            Text(
                modifier = Modifier
                    .width(32.dp)
                    .padding(bottom = 8.dp),
                text = prayerTime,
                fontSize = 12.sp,
                minLines = 2,
                textAlign = TextAlign.Center,
                color = selectedTextColor
            )
        }
    }
}

@Preview
@Composable
fun SinglePrayerPrev() {
    SinglePrayer(true, "Maghrib", "05:30 PM")
}


@Composable
fun AzkarItem(modifier: Modifier = Modifier, title: String, @DrawableRes backGround: Int) {
    Card(
        backgroundColor = Color.Transparent,
        modifier = modifier
            .height(160.dp)
            .width(285.dp)
    ) {
        Column(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = backGround),
                    contentScale = ContentScale.FillBounds
                )
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 4.dp, top = 8.dp, bottom = 8.dp),
                text = title,
                textAlign = TextAlign.Start,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                text = "بسم الله الرحمن الرحيم\n" +
                        "قُلۡ هُوَ ٱللَّهُ أَحَدٌ (1) ٱللَّهُ ٱلصَّمَدُ (2) لَمۡ يَلِدۡ وَلَمۡ " +
                        "يُولَدۡ (3) وَلَمۡ يَكُن لَّهُۥ كُفُوًا أَحَدُۢ (4)",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun AzkarItemPrev() {
    AzkarItem(title = "Evening Azkar", backGround = R.drawable.evenning_azkar_bg)
}