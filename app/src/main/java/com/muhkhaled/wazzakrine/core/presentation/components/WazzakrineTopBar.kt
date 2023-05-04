package com.muhkhaled.wazzakrine.core.presentation.components

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muhkhaled.wazzakrine.R
import com.muhkhaled.wazzakrine.core.presentation.theme.WazzakrineTheme


@Composable
private fun TopAppBarText(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier.padding(start = 12.dp),
        text = text.uppercase(),
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun MenuField() {
    Box(
        modifier = Modifier
            .height(56.dp)
            .padding(end = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "Menu", color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Divider(
            modifier = Modifier.align(Alignment.BottomCenter),
            color = MaterialTheme.colors.onPrimary.copy(alpha = ContentAlpha.disabled)
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WazzakrineTopBar(
    backdropRevealed: Boolean,
    onBackdropReveal: (Boolean) -> Unit = {},
) {
    TopAppBar(
        title = {
            val density = LocalDensity.current
            Box(
                Modifier
                    .width(46.dp)
                    .fillMaxHeight()
                    .toggleable(
                        value = backdropRevealed,
                        onValueChange = { onBackdropReveal(it) },
                        indication = rememberRipple(bounded = false, radius = 56.dp),
                        interactionSource = remember { MutableInteractionSource() }
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                AnimatedVisibility(
                    visible = !backdropRevealed,
                    enter = fadeIn(
                        animationSpec = tween(
                            durationMillis = 180,
                            delayMillis = 90,
                            easing = LinearEasing
                        )
                    )
                            + slideInHorizontally(
                        initialOffsetX = { with(density) { (-20).dp.roundToPx() } },
                        animationSpec = tween(durationMillis = 270, easing = LinearEasing)
                    ),
                    exit = fadeOut(
                        animationSpec = tween(
                            durationMillis = 120,
                            easing = LinearEasing
                        )
                    )
                            + slideOutHorizontally(
                        targetOffsetX = { with(density) { (-20).dp.roundToPx() } },
                        animationSpec = tween(durationMillis = 120, easing = LinearEasing)
                    ),
                    label = "Menu navigation icon"
                ) {
                    // todo navigation icon get from mostafa
                    Icon(
                        painterResource(id = R.drawable.ic_wazzakrine_menu),
                        contentDescription = "Menu navigation icon"
                    )
                }
                val logoTransition = updateTransition(
                    targetState = backdropRevealed,
                    label = "logoTransition"
                )
                val logoOffset by logoTransition.animateDp(
                    transitionSpec = {
                        if (targetState) {
                            tween(durationMillis = 120, easing = LinearEasing)
                        } else {
                            tween(durationMillis = 270, easing = LinearEasing)
                        }
                    },
                    label = "logoOffset"
                ) { revealed ->
                    if (!revealed) 20.dp else 0.dp
                }
                // wazzkrine logo
                Image(
                    painterResource(id = R.drawable.wazzkrine_logo),
                    contentDescription = "Wazzakrine logo",
                    modifier = Modifier.offset(x = logoOffset)
                )
            }
            AnimatedContent(
                targetState = backdropRevealed,
                transitionSpec = {
                    if (targetState) {
                        // Conceal to reveal
                        fadeIn(
                            animationSpec = tween(
                                durationMillis = 240,
                                delayMillis = 120,
                                easing = LinearEasing
                            )
                        ) +
                                slideInHorizontally(
                                    initialOffsetX = { with(density) { 30.dp.roundToPx() } },
                                    animationSpec = tween(
                                        durationMillis = 270,
                                        easing = LinearEasing
                                    )
                                ) with
                                fadeOut(
                                    animationSpec = tween(
                                        durationMillis = 120,
                                        easing = LinearEasing
                                    )
                                ) +
                                slideOutHorizontally(
                                    targetOffsetX = { with(density) { (-30).dp.roundToPx() } },
                                    animationSpec = tween(
                                        durationMillis = 120,
                                        easing = LinearEasing
                                    )
                                )
                    } else {
                        // Reveal to conceal
                        fadeIn(
                            animationSpec = tween(
                                durationMillis = 180,
                                delayMillis = 90,
                                easing = LinearEasing
                            )
                        ) +
                                slideInHorizontally(
                                    initialOffsetX = { with(density) { (-30).dp.roundToPx() } },
                                    animationSpec = tween(
                                        durationMillis = 270,
                                        easing = LinearEasing
                                    )
                                ) with
                                fadeOut(
                                    animationSpec = tween(
                                        durationMillis = 90,
                                        easing = LinearEasing
                                    )
                                ) +
                                slideOutHorizontally(
                                    targetOffsetX = { with(density) { 30.dp.roundToPx() } },
                                    animationSpec = tween(
                                        durationMillis = 90,
                                        easing = LinearEasing
                                    )
                                )
                    }.using(SizeTransform(clip = false))
                },
                contentAlignment = Alignment.CenterStart
            ) { revealed ->
                if (!revealed) {
                    TopAppBarText(text = "Wazzakrine")
                } else {
                    MenuField()
                }
            }
        },
        elevation = 0.dp
    )
}


@Preview
@Composable
fun WazzkrineTopBarPrev() {
    WazzakrineTheme {
        Surface {
            Column(Modifier.padding(20.dp)) {
                WazzakrineTopBar(false)
                Spacer(modifier = Modifier.height(8.dp))
                WazzakrineTopBar(true)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationMenu(
    modifier: Modifier = Modifier,
    backdropRevealed: Boolean = true,
    activeRoute: Routes = Routes.Home,
    onMenuSelect: (Routes) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = backdropRevealed, enter = EnterTransition.None,
            exit = ExitTransition.None,
            label = "Navigation menu"
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                val routes = Routes.values()

                routes.forEachIndexed { idx, route ->
                    MenuItem(
                        modifier = Modifier.clickable { onMenuSelect(route) },
                        index = idx
                    ) {
                        MenuText(
                            text = route.toString(),
                            color = if (route == activeRoute) Color.Gray else Color.Transparent
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimatedVisibilityScope.MenuItem(
    modifier: Modifier = Modifier,
    index: Int,
    content: @Composable () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .animateEnterExit(
                enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = 240,
                        delayMillis = index * 15 + 60,
                        easing = LinearEasing
                    )
                ),
                exit = fadeOut(animationSpec = tween(durationMillis = 90, easing = LinearEasing)),
                label = "Menu item $index"
            )
            .fillMaxWidth(0.5f)
            .clip(MaterialTheme.shapes.medium)
            .then(modifier)
    ) {
        content()
    }
}

@Composable
private fun MenuText(
    text: String = "Item",
    activeDecoration: @Composable () -> Unit = {},
    color: Color,
) {
    Box(
        modifier = Modifier.height(44.dp),
        contentAlignment = Alignment.Center
    ) {
        activeDecoration()
        Text(
            modifier = Modifier
                .background(
                    color = color,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(12.dp),
            text = text.uppercase(),
            style = MaterialTheme.typography.subtitle1,
        )
    }
}


enum class Routes {
    Home,
    Azkar,
    PrayerTimes,
    Elsebha,
    NameOfAllah,
    Elnawaya,
    Settings,
    AboutApp,
    Developers
}