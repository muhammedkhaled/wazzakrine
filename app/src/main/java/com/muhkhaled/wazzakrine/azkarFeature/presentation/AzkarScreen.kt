package com.muhkhaled.wazzakrine.azkarFeature.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhkhaled.wazzakrine.R
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme

@Composable
fun AzkarScreen() {

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
                    text = "..(الًبقتم الًمعو ابًيط اقًزرو اعًفان امًلع كلُأسأ ينإ مَّهللا)",
                    fontSize = 24.sp
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

    val items = listOf(AzkarScreens)
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), content = {
    })
}


data class AzkarItem(
    @DrawableRes val resourceId: Int,
    val size: Dp,
    val name: String,
    val type: AzkarScreens,
)

sealed class AzkarScreens {
    companion object ss {
        object MorningZeker : AzkarScreens()
        object EveningZeker : AzkarScreens()
        object PrayZeker : AzkarScreens()
        object TravelZeker : AzkarScreens()
        object EatingZeker : AzkarScreens()
        object SleepZeker : AzkarScreens()
    }
}

@Preview
@Composable
fun TodaysDuaPrev() {
    WazzakrineTheme {
        TodayDua()
    }
}

