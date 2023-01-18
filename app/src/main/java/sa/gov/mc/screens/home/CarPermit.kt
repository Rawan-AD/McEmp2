package sa.gov.mc.screens.home


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme.typography

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


import sa.gov.mc.R

import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.AppHeader


@Composable
fun CarPermit(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize().
                padding(horizontal = 10.dp)
                .background(GrayBackground)
        ) {
            val (header, content) = createRefs()


           AppHeader(title ="بطاقة" , description = "تصريح سيارة", navController = navController, modifier =  Modifier

                .constrainAs(header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },"homeScreen" )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(horizontal = 10.dp)

                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    }, horizontalAlignment = Alignment.CenterHorizontally

            ){

                    Spacer(Modifier.height(5.dp))
                    Card(
                        elevation = 2.dp,
                        shape = Shapes.ExtraMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.Start,    modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 17.5.dp)) {

                            Spacer(Modifier.height(16.dp))
                            Image(
                                painterResource(id = R.drawable.person),
                                contentDescription = null,
                                Modifier
                                    .clip(
                                        CircleShape
                                    )
                                    .absolutePadding(right = 130.dp),Alignment.Center,
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.height(12.dp))
                            Text(
                                "تركي محمد الشهراني",
                                style = typography.body2,
                                color = Dark_Green,
                                fontFamily = frutiger,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.absolutePadding(left=88.dp,right=89.dp)
                            )

                            Spacer(Modifier.height(5.dp))
                            Text("مطور تطبيقات", style = typography.body2, color = PrimaryColor,modifier = Modifier.absolutePadding(right=125.dp))
                            Spacer(Modifier.height(18.dp))


                            DividerFactory()
                            CarInfo(
                                right = 31.5.dp,
                                top = 7.dp,
                                bottom = 11.dp,
                                title = "نوع السيارة",
                                Description = "تويوتا"
                            )
                            Spacer(Modifier.height(13.dp))
                            DividerFactory()
                            CarInfo(
                                right = 53.5.dp,
                                top = 4.dp,
                                bottom = 15.dp,
                                title = "تصنيف",
                                Description = "كامري"
                            )
                            Spacer(Modifier.height(13.dp))
                            DividerFactory()
                            CarInfo(
                                right = 29.5.dp,
                                top = 6.dp,
                                bottom = 13.dp,
                                title = "لون السيارة",
                                Description = "أزرق"
                            )
                            Spacer(Modifier.height(13.dp))
                            DividerFactory()
                            CarInfo(
                                right = 13.5.dp,
                                top = 6.dp,
                                bottom = 13.dp,
                                title = "موديل السيارة",
                                Description = "2020"
                            )
                            Spacer(Modifier.height(13.dp))
                            DividerFactory()
                            CarInfo(
                                right = 29.5.dp,
                                top = 5.dp,
                                bottom = 14.dp,
                                title = "مكان العمل",
                                Description = "المبنى الرئيسي"
                            )
                            Spacer(Modifier.height(13.dp))
                            DividerFactory()
                            CarInfo(
                                right = 61.5.dp,
                                top = 7.dp,
                                bottom = 12.dp,
                                title = "الإدارة ",
                                Description = "مكتب الوزير"
                            )
                            DividerFactory()
                            CarInfo(
                                right = 51.dp,
                                top = 4.dp,
                                bottom = 28.dp,
                                title = "رقم الجوال",
                                Description = "0555555555"
                            )

                        }

                    }


                }


            }



}
    }

@Composable
fun CarInfo(right: Dp, top: Dp, bottom: Dp, title: String, Description: String) {
    Row(modifier = Modifier.absolutePadding(right, top, bottom), verticalAlignment = Alignment.CenterVertically) {
        Text(title, style = typography.subtitle2,color=Dark_Gray_Black, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(14.dp))
        Text(Description, style = typography.body2,color= Brown_Gray)

    }
}

@Composable
fun DividerFactory() {
    Divider(
        color = Gray_Medium,
        thickness = 1.dp
    )
}

@Preview
@Composable
fun DefaultPreview12() {
    CarPermit(rememberNavController())
}