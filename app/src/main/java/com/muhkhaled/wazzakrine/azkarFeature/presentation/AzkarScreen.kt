package com.muhkhaled.wazzakrine.azkarFeature.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
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

@Composable
fun AzkarScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TodayDua(Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp))
        AzkarCategory(
            Modifier
                .padding(16.dp)
        )
    }
}


@Preview
@Composable
fun AzkarScreenPrev() {
    WazzakrineTheme {
        MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
            AzkarScreen()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TodayDua(modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .paint(
                    painter = painterResource(id = R.drawable.todays_dua_img),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.handwithsebha_img),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "Today's Dua",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 16.dp
                    ),
                    text = "اللَّهمَّ إنِّي أسألُكَ عِلمًا نافعًا ورزقًا طيِّبًا وعملًا متقبَّلًا",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                )
                TextButton(onClick = { }) {
                    Row(
                        modifier = Modifier.wrapContentSize(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            Icons.Default.Share,
                            tint = MaterialTheme.colors.primary,
                            contentDescription = null
                        )
                        Text(modifier = Modifier.padding(start = 8.dp), text = "Share")
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun TodaysDuaPrev() {
    WazzakrineTheme {
        TodayDua()
    }
}

@Composable
fun AzkarCategory(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.wrapContentHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ZekerItem(
                modifier = Modifier.height(174.dp).weight(1F),
                resourceId = R.drawable.morinig_img,
                zekerName = "Morning"
            )
            Column(
                modifier = Modifier
                    .height(174.dp)
                    .weight(1F)
                    .padding(start = 8.dp)
            ) {
                Row(
                    modifier = Modifier.weight(1F),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ZekerItem(
                        modifier = Modifier.weight(1F),
                        resourceId = R.drawable.travel_img,
                        zekerName = "Travel"
                    )
                    ZekerItem(
                        modifier = Modifier
                            .weight(1F)
                            .padding(start = 8.dp),
                        resourceId = R.drawable.food_img,
                        zekerName = "Food & Drink"
                    )
                }
                ZekerItem(
                    modifier = Modifier
                        .weight(1F)
                        .padding(top = 8.dp),
                    resourceId = R.drawable.sleep_img,
                    zekerName = "Sleep"
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth().wrapContentHeight()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ZekerItem(
                modifier = Modifier
                    .height(174.dp)
                    .weight(1F),
                resourceId = R.drawable.pray_img,
                zekerName = "Pray"
            )
            ZekerItem(
                modifier = Modifier
                    .height(174.dp)
                    .weight(1F)
                    .padding(start = 8.dp),
                resourceId = R.drawable.evening_img,
                zekerName = "Evening"
            )
        }
    }
}

@Preview
@Composable
fun AzkarCategoryPrev() {
    WazzakrineTheme {
        MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
            AzkarCategory()
        }
    }
}


@Composable
fun ZekerItem(
    modifier: Modifier = Modifier,
    @DrawableRes resourceId: Int,
    zekerName: String,
) {
    Card(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = resourceId),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp),
                text = zekerName,
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ZekarItemPrev() {
    WazzakrineTheme {
        ZekerItem(
            modifier = Modifier.size(width = 162.dp, height = 174.dp),
            resourceId = R.drawable.evenning_azkar_bg,
            zekerName = "Morning"
        )
    }
}

