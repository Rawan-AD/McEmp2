package sa.gov.mc.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.AppBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileUi(navController: NavController) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Scaffold(
            backgroundColor = GrayBackground,
            modifier = Modifier.fillMaxSize()
            ,

            topBar = {
                AppBar(title = "حساب", subTitle = "الموظف", navController, Screens.HomeScreen.route)

            },


            content = {
                Column(
                    modifier = Modifier

                        .absolutePadding(right = 9.dp, left = 10.dp)
                        .fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(14.dp))
                    Card(
                        Modifier
                            .height(331.dp)
                            .fillMaxWidth(), elevation = 3.dp
                    ) {

                        Spacer(Modifier.height(40.dp))


                        Column(
                            Modifier
                                .height(331.dp)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                            ) {

                                Card(  Modifier.size(140.dp),shape = CircleShape, elevation =2.dp) {
                                    Image(
                                        painterResource(id = R.drawable.person),
                                        contentDescription = null,
                                        Modifier

                                            .size(140.dp)
                                            .clip( shape= CircleShape).fillMaxSize()

                                            .clickable { navController.navigate(Screens.EmpCard.route)},
                                        contentScale = ContentScale.Crop
                                    )
                                }
                                Custom_Draw_Bell_Profile( painterResource(id = R.drawable.icon_awesome_bell),10.dp,100.dp, Grayiesh_Brown,24.dp,14.dp)
                                Custom_Draw_Bell_Profile(painterResource(id = R.drawable.icon_awesome_qrcode),100.dp,1.dp,
                                    PrimaryColor,32.dp,24.dp)

                            }
                            Spacer(modifier = Modifier.height(23.dp))
                            Text(
                                "تركي الشهراني",
                                color = Sea,
                                style = typography.subtitle2,
                                modifier = Modifier.graphicsLayer(alpha = 0.99f),
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(18.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {


                                Text(
                                    "الرقم الوظيفي",
                                    fontSize = 12.sp,
                                    style = typography.subtitle5
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    "1473",
                                    style = typography.subtitle3,
                                    color = Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(11.dp))
                                Image(
                                    painterResource(id = R.drawable.ic_copy),
                                    contentDescription = null,
                                    Modifier.size(10.dp, 11.4.dp)
                                )
                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ProfileCard(
                            White,
                            "تسجيل حضور",
                            Text_Gray,
                            painterResource(id = R.drawable.signin)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        ProfileCard(
                            Dark_Red,
                            "تسجيل انصراف",
                            White,
                            painterResource(id = R.drawable.signout)
                        )


                    }

                    Spacer(modifier = Modifier.height(23.5.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        ProfileCard3("07:36 صـ", Sea)
                        Spacer(modifier = Modifier.width(16.dp))
                        ProfileCard3("07:36 صـ", Dark_Red)

                    }
                    Spacer(modifier = Modifier.height(27.5.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ProfileCard2(
                            painterResource(id = R.drawable.group_135),
                            18.5,
                            "رصيد إجازات",
                            "يوم"
                        )
                        Spacer(modifier = Modifier.width(17.dp))
                        ProfileCard2(
                            painterResource(id = R.drawable.paper),
                            2.0,
                            "الطلبات الحالية",
                            "طلب"
                        )
                    }
                }
            }


        )
    }
}

@Composable
fun ProfileCard(color: Color, title: String, contentColor: Color, image1: Painter) {
    Card(
        modifier = Modifier
            .size(170.dp, 55.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color)

        ) {
            Text(
                title,
                style = Typography.subtitle6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.absolutePadding(top = 13.4.dp, right = 10.dp),
                color = contentColor
            )

            Spacer(modifier = Modifier.width(18.dp))
            Image(
                image1,
                contentDescription = null,
                Modifier.absolutePadding(top = 13.4.dp, right = 10.dp, left = 11.dp)
            )
        }
    }

}

@Composable
fun ProfileCard2(painter: Painter, number: Double, title: String, service: String) {
    Card(
        modifier = Modifier
            .size(170.dp, 80.dp), shape = Shapes.ExtraMedium, elevation = 3.dp
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            Image(
                painter, contentDescription = null, modifier = Modifier
                    .absolutePadding(top = 22.dp, right = 13.dp)
            )
            Spacer(modifier = Modifier.width(18.dp))


            Column(Modifier.absolutePadding(top = 9.dp, left = 8.dp)) {

                Text(title, style = typography.subtitle5)
                Spacer(modifier = Modifier.height(4.8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(number.toString(), color = Bluish, fontSize = 22.sp)
                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        service,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.frutiger_roman))
                    )
                }

            }
        }

    }
}

@Composable
fun ProfileCard3(title: String, contentColor: Color) {
    Card(
        modifier = Modifier
            .size(170.dp, 80.dp)
          ,shape = Shapes.ExtraMedium,

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(GrayBackground),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, fontSize = 20.sp, color = contentColor, fontWeight = FontWeight.Bold)


        }

    }
}


@Preview
@Composable
fun DefaultPreview12() {
    ProfileUi(rememberNavController())
}





@Composable
fun Custom_Draw_Bell_Profile(image:Painter,x: Dp,
    y: Dp,
    background: Color,
    size: Dp,
    imageSize: Dp
) {

    Box(
        modifier = Modifier
            .size(size)
            .offset(x, y)
            .drawBehind {
                drawRect(
                    color = background

                )
            }, contentAlignment = Alignment.Center
    ) {
        Image(
          image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(imageSize)
        )
    }

}

