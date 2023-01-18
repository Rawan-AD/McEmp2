package sa.gov.mc.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.VerticalPagerIndicator
import sa.gov.mc.ui.theme.Orange
import sa.gov.mc.ui.theme.Shapes

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeAnnouncement(list: ArrayList<Home>, pagerState: PagerState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

            .clip(shape = Shapes.medium)
            .background(Orange)
            .height(80.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            VerticalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.padding(8.dp),
                activeColor = Color.White
            )
            VerticalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(1f),
                count = 3
            ) { page ->
                HomePagerUI(list[page])
            }


        }

    }

}