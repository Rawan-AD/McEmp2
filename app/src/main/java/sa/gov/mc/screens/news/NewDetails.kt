package sa.gov.mc.screens.news

import androidx.compose.foundation.*

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import sa.gov.mc.R
import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.flag


@Composable
fun NewsHeader(modifier: Modifier, navController: NavController,route:String) {
    Card(
        modifier = modifier.fillMaxWidth(), shape = Shapes.ExtraMedium, elevation = 6.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(vertical = 14.dp, horizontal = 8.dp)
        ) {
            Text(
                "٢٧ جمادي الثانية 1440 هـ",
                modifier = Modifier.align(Alignment.CenterEnd),
                fontFamily = frutiger,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Medium_Gray
            )


            Row(Modifier.align(Alignment.CenterStart)) {
                Icon(Icons.Default.KeyboardArrowRight,
                    tint = Medium_Gray,
                    contentDescription = "image_back",
                    modifier = Modifier.padding(5.dp).
                    clickable { navController.navigate(route) }

                )

                Text(
                    text = "عودة",
                    fontFamily = frutiger,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Medium_Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun NewDetails(navController: NavController) {
    val density = LocalDensity.current
    var imageSize by remember { mutableStateOf(IntSize.Zero) }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .padding(horizontal = 16.dp)
        ) {
            val (header, content, bottomBar) = createRefs()
            var rou="homeScreen"
if(flag==0){
    rou="homeScreen"
} else{
    rou="NewsUI"
}

            NewsHeader(navController = navController,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }, route = rou
            )



                        Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .verticalScroll(rememberScrollState())
                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(bottomBar.top)
                        height = Dimension.fillToConstraints
                    },
                shape = Shapes.ExtraMedium,
                elevation = 6.dp,
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(vertical = 10.dp, horizontal = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_box),
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(10.dp)
                                )
                                .fillMaxSize()
                                .onSizeChanged {
                                    imageSize = it
                                },
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds
                        )

                        Box(
                            modifier = Modifier
                                .height(((imageSize.height / 2) / density.density).dp)
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            WHITE_LIGHT, WHITE_MEDIUM
                                        )
                                    )
                                )
                        )

                    }

                    Text(
                        text = stringResource(id = R.string.str_dummy_head),
                        fontFamily = frutiger,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Dark_Blue_Green,
                        style = TextStyle(textDirection = TextDirection.Content),
                        modifier = Modifier.padding(horizontal = 20.dp),
                        lineHeight = 25.sp
                    )

                    Text(
                        text = stringResource(id = R.string.str_dummy_content),
                        fontFamily = frutiger,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Brown_Gray,
                        style = TextStyle(textDirection = TextDirection.Content),
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                        lineHeight = 25.sp
                    )


                    Row(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painterResource(id = R.drawable.person),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(25.dp)
                                ),
                            contentScale = ContentScale.Fit
                        )

                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Text("فلان الفلان الفلاني", style = MaterialTheme.typography.subtitle2)
                            Text(".Net Developer", style = MaterialTheme.typography.subtitle3)
                        }
                    }
                }

            }


            BottomNavBar(modifier = Modifier.constrainAs(bottomBar) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        }


    }


}


@Composable
fun BottomNavBar(modifier: Modifier) {
    var bottomState by remember {
        mutableStateOf("News")
    }
    BottomNavigation(
        backgroundColor = White,
        contentColor = Color(0xfff999999),
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    30.dp
                )
            )
    ) {
        BottomNavigationItem(
            selected = bottomState == "News",
            onClick = { bottomState = "News" },
            label = { Text("تعليق", color = Text_Gray) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_awesome_comment_alt),
                    contentDescription = null
                )
            },
        )
        BottomNavigationItem(
            selected = bottomState == "News",
            onClick = { bottomState = "News" },
            label = { Text("المفضلة", color = Text_Gray) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_metro_star_empty),
                    contentDescription = null
                )
            },
        )
        BottomNavigationItem(
            selected = bottomState == "News",
            onClick = { bottomState = "News" },
            label = { Text("مشاركة", color = Text_Gray) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_feather_share),
                    contentDescription = null
                )
            },
        )


    }
}


@Preview
@Composable
fun defaultPreview17() {
//    NewDetails(rememberNavController())
}
