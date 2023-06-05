package com.muhkhaled.wazzakrine.DescriptionOfAllahName.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
fun DescriptionOfAllahNameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Name Description",
            fontSize = 16.sp
        )
        DescriptionCard(
            modifier = Modifier.padding(top = 16.dp),
        )
    }
}

@Composable
fun DescriptionCard(modifier: Modifier = Modifier) {
    // todo allah name data class with name, id, description, video urls on both En/Ar
    Card(
        modifier = modifier
            .wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                modifier = Modifier.align(Alignment.TopEnd),
                painter = painterResource(id = R.drawable.shape_top_end),
                contentDescription = null
            )
            Image(
                modifier = Modifier.align(Alignment.BottomStart),
                painter = painterResource(id = R.drawable.shape_bottom_start),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(
                        top = 40.dp,
                        bottom = 40.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                text = "الرحمن: هو ذو الرحمة الشاملة لجميع الخلائق في الدنيا وللمؤمنين في الآخرة، أي: إن رحمته عامة تشمل المؤمن والكافر في الدنيا وخاصة بالمؤمنين فقط في الآخرة قال تعالى: {الرَّحْمَنُ عَلَى الْعَرْشِ اسْتَوَى} [طه:5]. ",
                textAlign = TextAlign.End,
            )
        }
    }
}

@Preview
@Composable
fun DescriptionOfAllahNameScreenPrev() {
    WazzakrineTheme {
        MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
            DescriptionOfAllahNameScreen()
        }
    }
}