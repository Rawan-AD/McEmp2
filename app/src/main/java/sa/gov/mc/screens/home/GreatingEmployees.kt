package sa.gov.mc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.R
import sa.gov.mc.screens.contacts.cirlcle
import sa.gov.mc.ui.theme.*

@Composable
fun GreatingEmployees(newEmployees: List<Home>) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),

        shape = Shapes.ExtraExtraSmall
    ) {
        Column(
            modifier = Modifier
                .size(365.dp, 157.dp)

                .background(Color.White)

        ) {
            Row(
                Modifier.absolutePadding(
                    left = 12.dp,
                    right = 12.dp,
                    bottom = 4.dp,
                    top = 4.dp
                )
            )
            {

                Text(
                    text = "مرحباً ",
                    fontFamily = frutiger,
                    textAlign = TextAlign.Left,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,


                    )

                Spacer(modifier = androidx.compose.ui.Modifier.width(6.dp))

                Text(
                    text = "بكم",
                    fontFamily = frutiger,
                    style = MaterialTheme.typography.subtitle2,
                    textAlign = TextAlign.Left,
                    color = Dark_Green,
                    fontWeight = FontWeight.Bold,

                    )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.absolutePadding(
                    23.dp,
                    6.dp,
                    8.dp,
                    28.dp
                )
            ) {
                LazyRow (Modifier.fillMaxWidth()){
                    items(newEmployees.size) { item ->
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box() {
                                Image(
                                    painter = newEmployees[item].image,
                                    contentDescription = null,
                                    modifier = Modifier

//                                                            .absolutePadding(right = 17.dp)
                                        .size(70.dp, 70.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop,
                                )

                                cirlcle(
                                    painterResource(id = R.drawable.socialcall),
                                    4.dp,
                                    55.dp,
                                    Color.White,
                                    19.7.dp,
                                    11.2.dp
                                )
                                cirlcle(
                                    painterResource(id = R.drawable.message),
                                    44.dp,
                                    55.dp,
                                    Color.White,
                                    22.5.dp,
                                    11.2.dp
                                )

                            }



                            Text(
                                text = newEmployees[item].title,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.size(162.dp, 71.dp),
                                style = MaterialTheme.typography.subtitle3,
                                color = Gray_Home
                            )

                        }
                    }
                }


            }
        }
    }

}