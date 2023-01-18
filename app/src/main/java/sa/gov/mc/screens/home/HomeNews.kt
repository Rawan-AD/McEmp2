package sa.gov.mc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import sa.gov.mc.Screens
import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.flag

@Composable
fun HomeNews(newsList: List<Home>, navController: NavController) {
    Card(


        shape = Shapes.ExtraExtraSmall
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(365.dp, 253.dp)

                .background(Color.White)
                .height(611.dp)
                .padding(10.dp)


        ) {

            Row(
                Modifier.absolutePadding(left = 12.dp, right = 12.dp)

            ) {

                Text(
                    text = "أخبار",
                    fontFamily = frutiger,
                    textAlign = TextAlign.Left,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,


                    )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "الوزارة",
                    fontFamily = frutiger,
                    textAlign = TextAlign.Left,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Dark_Green
                )
            }

            LazyRow {
                items(newsList.size) { item ->
                    Column(horizontalAlignment = Alignment.Start) {
                        Box() {
                            Image(
                                painter = newsList[item].image,
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width = 162.dp)
                                    .height(132.dp)
                                    .clip(
                                        Shapes.large
                                    ),
                                contentScale = ContentScale.Fit
                            )
                            TextWithShadow(
                                text = "27 جمادى الثانية 1443 هـ",
                                modifier = Modifier.absolutePadding(
                                    top = 105.dp,
                                    bottom = 3.dp,
                                    right = 4.dp
                                )
                            )


                        }
                        Text(
                            text = newsList[item].title,
                            modifier = Modifier
                                .size(162.dp, 71.dp)
                                .clickable { navController.navigate(Screens.News.route)
                                           flag=0},
                            fontSize = 12.sp,
                            fontFamily = frutiger,
                            fontWeight = FontWeight.Light
                        )

                    }
                }


            }

        }
    }
}