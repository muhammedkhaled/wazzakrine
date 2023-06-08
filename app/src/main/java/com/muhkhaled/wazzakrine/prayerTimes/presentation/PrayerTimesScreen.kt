package com.muhkhaled.wazzakrine.prayerTimes.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
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
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme

@Composable
fun PrayerTimesScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        PrayerTimesHeader()
        DateCard(modifier = Modifier.offset(y = (-28).dp))
        AllPrayersCard()
    }
}

@Preview
@Composable
fun PrayerTimesScreenPrev() {
    WazzakrineTheme() {
        PrayerTimesScreen()
    }
}

@Composable
fun PrayerTimesHeader(modifier: Modifier = Modifier) {
    Card(
        backgroundColor = Color.Transparent,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
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
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}

@Composable
fun DateCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 24.dp, top = 20.dp, bottom = 20.dp),
                imageVector = Icons.Filled.ArrowLeft,
                contentDescription = null
            )
            Column(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "8 Ramadan 1444 AH", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Sunday, 5 May", fontSize = 14.sp)
            }
            Icon(
                modifier = Modifier.padding(end = 24.dp, top = 20.dp, bottom = 20.dp),
                imageVector = Icons.Filled.ArrowRight,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun DataCardPrev() {
    WazzakrineTheme {
        DateCard()
    }
}


@Composable
fun AllPrayersCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            PrayerItem(icon = R.drawable.prayer_fajer_ic, prayerName = "Fajer", time = "05:15 AM")
            PrayerItem(icon = R.drawable.prayer_sunrise_ic, prayerName = "Sunrise", time = "06:15 AM")
            PrayerItem(icon = R.drawable.prayer_duhr_ic, prayerName = "Duhr", time = "12:02 PM")
            PrayerItem(icon = R.drawable.prayer_asr_ic, prayerName = "Asr", time = "03:02 PM")
            PrayerItem(icon = R.drawable.prayer_maghreb_ic, prayerName = "Maghreb", time = "05:30 PM")
            PrayerItem(icon = R.drawable.prayer_isha_ic, prayerName = "Isha", time = "06:45 PM")
        }
    }
}

@Preview
@Composable
fun AllPrayersCardPrev() {
    WazzakrineTheme() {
        AllPrayersCard()
    }
}

@Composable
fun PrayerItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    prayerName: String,
    time: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 16.dp, end = 8.dp),
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            text = prayerName,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, end = 16.dp),
            text = time,
            fontSize = 14.sp
        )
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}

@Preview
@Composable
fun PrayerItemPrev() {
    WazzakrineTheme() {
        PrayerItem(icon = R.drawable.prayer_fajer_ic, prayerName = "Fajer", time = "05:15 AM")
    }
}