package sa.gov.mc.screens.jobs

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.utility.CardDate
import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.CustomButton


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmpJob(navController: NavController) {
    var expand by remember { mutableStateOf(false) } // Expand State
    val rotationState by animateFloatAsState(if (expand) 180f else 0f) // Rotation State
    var stroke by remember { mutableStateOf(1) } // Stroke State
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        )
        {
            val (header, content) = createRefs()


            Spacer(Modifier.height(16.dp))
            JobHeader(
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })


            Spacer(Modifier.height(12.dp))




            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)

                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    }, horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Spacer(Modifier.height(12.dp))
                Divider(modifier = Modifier.padding(horizontal = 10.dp), color = Gray_Search)
                Spacer(Modifier.height(16.dp))



                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    CardDate(title = "المدينة", Icons.Default.KeyboardArrowDown)
                    Spacer(modifier = Modifier.width(30.dp))
                    CardDate(title = "حتى تاريخ", Icons.Default.DateRange)


                }

                var jobsList = mutableListOf<JobInfo>()
                jobsList.add(JobInfo("محامي", "الادارة العليا", "الرياض", "اقل من سنتين"))
                jobsList.add(JobInfo("مطور اندرويد", "قسم التطوير ", "الرياض", "سنه فأكثر"))


                Spacer(Modifier.height(19.dp))
                LazyColumn() {
                    items(jobsList.size) { item ->
                        Card(
                            modifier = Modifier
                                .size(344.dp, 151.dp)
                                .animateContentSize( // Animation
                                    animationSpec = tween(
                                        durationMillis = 400, // Animation Speed
                                        easing = LinearOutSlowInEasing // Animation Type
                                    )
                                )

                                .padding(horizontal = 16.dp),
                            shape = Shapes.ExtraExtraExtraSmall,
                            border = BorderStroke(1.dp, Gray_Search),
                            backgroundColor = Color.White,
                            onClick = {
                                expand = !expand
                                stroke = if (expand) 2 else 1
                            }

                        ) {
                            Column(
                                modifier = Modifier.absolutePadding(right = 18.dp),
                                horizontalAlignment = Alignment.Start,
                            ) {
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    "باحث قضايا",
                                    fontFamily = frutiger,
                                    fontWeight = FontWeight.Bold,
                                    color = Brown_Gray,
                                    fontSize = 14.sp
                                )
                                Spacer(Modifier.height(15.dp))
                                Divider(
                                    modifier = Modifier.padding(horizontal = 10.dp),
                                    color = Gray_Search
                                )

                                Spacer(Modifier.height(11.8.dp))
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.department),
                                        contentDescription = null
                                    )
                                    Spacer(Modifier.width(5.7.dp))
                                    Text(
                                        text = "الادارة العامة للغرف التجارية",
                                        style = MaterialTheme.typography.body2,
                                        color = Brown_Gray,
                                        fontSize = 13.sp,
                                        fontFamily = FontFamily(Font(R.font.frutiger_roman))
                                    )
                                }
                                Spacer(Modifier.height(10.dp))
                                Divider(
                                    modifier = Modifier.padding(horizontal = 10.dp),
                                    color = Gray_Search
                                )
                                Spacer(Modifier.height(7.dp))
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.icon_awesome_map_marker_alt),
                                        contentDescription = null
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    Text(
                                        text = "الرياض",
                                        style = MaterialTheme.typography.body2,
                                        color = Brown_Gray,
                                        fontSize = 13.sp,
                                        fontFamily = FontFamily(Font(R.font.frutiger_roman))

                                    )
                                    Spacer(Modifier.width(112.dp))
                                    Image(
                                        painterResource(id = R.drawable.group_177),
                                        contentDescription = null
                                    )
                                    Spacer(Modifier.width(8.dp))
                                    Text(
                                        text = "سنتين وأكثر",
                                        fontSize = 13.sp,
                                        style = MaterialTheme.typography.body2,
                                        color = Brown_Gray,
                                        fontFamily = FontFamily(Font(R.font.frutiger_roman))

                                    )


                                }

                                Spacer(Modifier.height(15.dp))
                                IconButton(
                                    modifier = Modifier
                                        .rotate(rotationState)
                                        .weight(.1f),
                                    onClick = {
                                        expand = !expand
                                        stroke = if (expand) 2 else 1
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        tint = Pinkish_Gray, // Icon Color
                                        contentDescription = "Drop Down Arrow",
                                        modifier = Modifier.absolutePadding(right = 120.dp)
                                    )
                                }


                            }
                        }

                        Spacer(Modifier.height(18.dp))

                    }


                    }

                CustomButton(title = "الوظائف", navController, Screens.JobsScreen.route, modifier = Modifier.size(128.dp,34.dp)
                    ,Brownish_Gray)


                }
            if (expand) {

                  CustomButton(
                        title = "تقديم",
                        navController = rememberNavController(),
                        "homeScreen",Modifier.size(128.dp,34.dp) ,Brownish_Gray
                    )
                }
            }


        }
    }
