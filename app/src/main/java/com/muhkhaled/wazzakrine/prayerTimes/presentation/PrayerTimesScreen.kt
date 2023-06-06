package com.muhkhaled.wazzakrine.prayerTimes.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhkhaled.wazzakrine.R
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme


@Composable
fun PrayerTimesScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            painter = painterResource(id = R.drawable.next_azan),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        DateCard(modifier = Modifier.offset(y = (-28).dp))
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
            
        }
    }
}