package com.muhkhaled.wazzakrine.azkarFeature.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhkhaled.wazzakrine.core.presentation.theme.BrightGray
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme
import com.muhkhaled.wazzakrine.R
import com.muhkhaled.wazzakrine.core.presentation.theme.LightTaupe
import com.muhkhaled.wazzakrine.core.presentation.theme.Shapes

@Composable
fun ZekerContentScreen(modifier: Modifier = Modifier, @StringRes screenTitle: Int) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(185.dp)
                .paint(
                    painter = painterResource(id = R.drawable.bg_morning_azkar),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Row(
                modifier = Modifier.align(Alignment.TopStart),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier.padding(16.dp),
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(start = 32.dp),
                    text = stringResource(id = screenTitle),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 20.dp, end = 20.dp, top = 34.dp, bottom = 36.dp),
                text = "{وَالذَّاكِرِينَ اللَّهَ كَثِيرًا وَالذَّاكِرَاتِ أَعَدَّ اللَّهُ لَهُم مَّغْفِرَةً وَأَجْرًا عَظِيمًا} [الأحزاب:35].",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        ContentListCard(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-24).dp)
        )
    }
}

@Preview
@Composable
fun ZekerContentScreenPrev() {
    WazzakrineTheme {
        MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
            ZekerContentScreen(screenTitle = R.string.app_name)
        }
    }
}

@Composable
fun ContentListCard(
    modifier: Modifier = Modifier,
    azkarList: List<Int> = remember { listOf(1,2,3,4,5)  },
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(topEnd = 28.dp),
        backgroundColor = BrightGray
    ) {
        LazyColumn() {
            items(count = azkarList.size, key = {
                azkarList[it]
            }) { zeker ->
                ZekerItem(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp))
            }
        }
    }
}

@Preview
@Composable
fun ContentListCardPrev() {
    WazzakrineTheme {
        MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
            ContentListCard()

        }
    }
}

// todo create data class holds zeker conent and hadith and count of reading and voise all based on localy ar/en
@Composable
fun ZekerItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .paint(
                    painter = painterResource(id = R.drawable.shape_card),
                    contentScale = ContentScale.FillBounds
                ).clickable {  },
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(
                        shape = RoundedCornerShape(8.dp), color = Color.LightGray
                    )
                    .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp),
                text = "1/27",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 24.dp, end = 24.dp),
                text = "اللهم إني أشهد أنك أنت الله لا إله إلا أنت الأحد الصمد الذي لم يلد ولم يولد ولم يكن له كفوا أحد",
                textAlign = TextAlign.End,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 24.dp, end = 24.dp),
                text = ".من قالها أعتقه الله من النار",
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = LightTaupe
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                ) {
                    Icon(
                        modifier = Modifier.padding(6.dp),
                        imageVector = Icons.Default.Share,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {}, modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "0/4",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
                IconButton(
                    onClick = {}, modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                ) {
                    Icon(
                        modifier = Modifier.padding(6.dp),
                        imageVector = Icons.Default.PlayArrow,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ZekrItemPrev() {
    WazzakrineTheme() {
        ZekerItem(modifier = Modifier.padding(16.dp))
    }
}

