package sa.gov.mc.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi

import androidx.compose.foundation.layout.*

import androidx.compose.material.ButtonDefaults.outlinedButtonColors

import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.screens.navigate
import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.Background

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingUI(
    navController: NavHostController,
) {
    val pagerState = rememberPagerState()
    Background()
    Column(

    ) {

        HorizontalPager(state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            count =  4
        ) { page ->
            PageUI(
                page = onboardPages[page])
        }

        HorizontalPagerIndicator(pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = PrimaryColor,
            inactiveColor = Pinkish_Gray
        )
        Box(
            modifier = Modifier.padding(24.dp)
        ) {

            this@Column.AnimatedVisibility(
                visible = pagerState.currentPage == 3
            ) {
                OutlinedButton(shape = Shapes.large ,
                    modifier = Modifier
                        .size(72.dp,40.dp)
                      ,
                    onClick = {  navController.navigate(route = Screens.LoginScreen.route)},
                    colors =outlinedButtonColors(
                        backgroundColor = Beige,
                        contentColor = Pinkish_Gray
                    )
                ) {
                    Text(text = stringResource(R.string.get_started))
                }
            }
            /**
             * skip feature implementation
             */
            this@Column.AnimatedVisibility(
                visible = pagerState.currentPage != 3
            ) {
                OutlinedButton(shape = Shapes.large ,
                    modifier = Modifier
                        .size(72.dp,40.dp)
                       ,
                    onClick = {  navController.navigate(route = Screens.LoginScreen.route) },
                    colors = outlinedButtonColors(
                        backgroundColor = Beige,
                        contentColor = Pinkish_Gray
                    )
                )
                { Text(text = stringResource(R.string.skip),fontSize=13.sp, textAlign = TextAlign.Center)
                }
            }
        }
    }
}

