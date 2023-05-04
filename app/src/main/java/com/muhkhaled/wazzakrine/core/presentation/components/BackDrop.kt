package com.muhkhaled.wazzakrine.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.muhkhaled.wazzakrine.core.presentation.theme.Platinum
import com.muhkhaled.wazzakrine.core.presentation.theme.Shapes
import com.muhkhaled.wazzakrine.home.presentation.HomeScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BackDrop(
    showScrim: Boolean = false,
    onBackdropReveal: (Boolean) -> Unit = {},
) {
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
    var backdropRevealed by rememberSaveable { mutableStateOf(scaffoldState.isRevealed) }
    val scope = rememberCoroutineScope()
    var activeRoute by rememberSaveable { mutableStateOf(Routes.Home) }

    BackdropScaffold(
        scaffoldState = scaffoldState,
        gesturesEnabled = true,
        appBar = {
            WazzakrineTopBar(
                backdropRevealed = backdropRevealed,
                onBackdropReveal = {
                    if (!scaffoldState.isAnimationRunning) {
                        backdropRevealed = it
                        onBackdropReveal(it)
                        scope.launch {
                            if (scaffoldState.isConcealed) {
                                scaffoldState.reveal()
                            } else {
                                scaffoldState.conceal()
                            }
                        }
                    }
                }
            )
        },
        frontLayerContent = {
            MaterialTheme(shapes = Shapes.copy(medium = RoundedCornerShape(8))) {
                HomeScreen(modifier = Modifier.padding(top = 24.dp))
            }
        },
        frontLayerShape = MaterialTheme.shapes.large,
        frontLayerElevation = 16.dp,
        frontLayerScrimColor = Platinum,
        frontLayerBackgroundColor = MaterialTheme.colors.background,
        backLayerContent = {
            NavigationMenu(
                modifier = Modifier.padding(top = 12.dp, bottom = 32.dp),
                backdropRevealed = backdropRevealed,
                activeRoute = activeRoute,
                onMenuSelect = {
                    backdropRevealed = false
                    onBackdropReveal(false)
                    activeRoute = it
                    scope.launch { scaffoldState.conceal() }
                })
        }
    )
}