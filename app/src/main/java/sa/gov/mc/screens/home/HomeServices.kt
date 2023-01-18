package sa.gov.mc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import sa.gov.mc.Screens
import sa.gov.mc.ui.theme.Dark_Gray_Black
import sa.gov.mc.ui.theme.ExtraExtraSmall
import sa.gov.mc.ui.theme.Shapes
import sa.gov.mc.ui.theme.subtitle4

@Composable
fun HomeServices(
    serviceList: List<Home>,
    openSheet: (BottomSheetScreen) -> Unit,
    navController: NavController
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            items(serviceList.size) { item ->
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .size(83.dp, 70.dp)
                        .clickable {
                            if (serviceList[item].title == "طلب إجازة") {
                                run { openSheet(BottomSheetScreen.VocationRequest) }
                            } else if (serviceList[item].title == "تصريح سيارة") {
                                navController.navigate(Screens.Car.route)
                            } else if (serviceList[item].title == "الوظائف") {
                                run { openSheet(BottomSheetScreen.EmpJob) }
                            } else {
                                navController.navigate(Screens.HomeScreen.route)
                            }

                        },
                    shape = Shapes.ExtraExtraSmall

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {


                        Image(
                            painter = serviceList[item].image,
                            contentDescription = "service_image",
                            modifier = Modifier
                                .width(width = 32.dp)
                                .height(32.dp),
                            contentScale = ContentScale.Fit
                        )
                        Text(
                            serviceList[item].title,
                            style = MaterialTheme.typography.subtitle4,
                            color = Dark_Gray_Black,
                            fontSize = 12.sp
                        )

                    }
                }





                Spacer(Modifier.width(19.dp))

            }
        }
    }


}