package sa.gov.mc.screens.jobs

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.utility.AppHeader

import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.Search


@Composable
fun JobInfo (navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .padding(horizontal = 10.dp)
        ) {
            val (header, content, bottomBar) = createRefs()


            AppHeader(
                "وظيفة", "باحث قضايا", navController = navController,
                modifier = Modifier
//                    .padding(vertical = 10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }, Screens.JobsScreen.route
            )




            Column(modifier = Modifier
                .fillMaxWidth()
//                .padding(vertical = 6.dp)
                .verticalScroll(rememberScrollState())
                .constrainAs(content) {
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomBar.top)
                    height = Dimension.fillToConstraints
                }) {



                    Search("بحث")
                    Spacer(Modifier.height(12.dp))
                    Card(
                        Modifier
                            .fillMaxWidth()
                            .height(450.dp)


                      ,
                        shape = Shapes.ExtraExtraExtraSmall,
                        border = BorderStroke(1.dp, Gray_Search), backgroundColor = White
                    )
                    {
                        Column(Modifier.padding(horizontal = 18.dp)) {
                            Spacer(Modifier.height(7.dp))
                            Text(
                                "باحث قضايا",
                                Modifier.absolutePadding(top = 5.dp),
                                style = typography.subtitle2,
                                fontFamily = FontFamily(
                                    Font(R.font.frutiger_roman)
                                )
                            )
                            Spacer(Modifier.height(15.dp))



                            Divider(color = Gray_Search, thickness = 1.dp)
                            Spacer(Modifier.height(11.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {

                                Image(
                                    painterResource(id = R.drawable.department),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(5.7.dp))
                                Text("الادارة العامة للشؤون القضائية", style = typography.subtitle4)

                            }
                            Spacer(Modifier.height(10.dp))
                            Divider(color = Gray_Search, thickness = 1.dp)
                            Spacer(Modifier.height(7.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {

                                Image(
                                    painterResource(id = R.drawable.icon_awesome_map_marker_alt),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(6.dp))
                                Text("الرياض", style = typography.subtitle4)
                                Spacer(Modifier.width(112.dp))
                                Image(
                                    painterResource(id = R.drawable.group_177),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(5.dp))
                                Text("سنتين وأكثر", style = typography.subtitle4)

                            }
                            Spacer(Modifier.height(13.dp))
                            Divider(color = Gray_Search, thickness = 1.dp)
                            Spacer(Modifier.height(12.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painterResource(id = R.drawable.icon_awesome_map_marker_alt),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(15.2.dp))
                                Text(
                                    "المؤهلات:",
                                    style = typography.subtitle2,
                                    fontFamily = FontFamily(
                                        Font(R.font.frutiger_roman)
                                    )
                                )
                                Spacer(Modifier.width(11.dp))
                                Text("بكالوريس/دبلوم", style = typography.subtitle4)

                            }
                            Spacer(Modifier.height(7.dp))
                            Divider(color = Gray_Search, thickness = 1.dp)
                            Spacer(Modifier.height(7.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painterResource(id = R.drawable.icon_awesome_map_marker_alt),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(4.2.dp))
                                Text(
                                    "المسؤوليات:",
                                    style = typography.subtitle2,
                                    fontFamily = FontFamily(
                                        Font(R.font.frutiger_roman)
                                    )
                                )
                                Spacer(Modifier.width(11.dp))
                                Text(
                                    "1- دراسة القضايا والشكاوى المرفوعة   \n2- دراسة القضايا والشكاوى المرفوعة\n3-دراسة القضايا والشكاوى المرفوعة\n4-دراسة القضايا والشكاوى المرفوعة" +
                                            "\n", style = typography.subtitle4
                                )


                            }
                            Spacer(Modifier.height(7.dp))
                            Divider(color = Gray_Search, thickness = 1.dp)
                            Spacer(Modifier.height(7.dp))
                            Row {
                                Image(
                                    painterResource(id = R.drawable.icon_awesome_map_marker_alt),
                                    contentDescription = null
                                )
                                Spacer(Modifier.width(4.2.dp))
                                Text(
                                    "التخصص:",
                                    style = typography.subtitle2,
                                    fontFamily = FontFamily(
                                        Font(R.font.frutiger_roman)
                                    )
                                )
                                Spacer(Modifier.width(15.dp))
                                Text(
                                    "قانون",
                                    style = typography.subtitle2,
                                    fontFamily = FontFamily(
                                        Font(R.font.frutiger_roman)
                                    )
                                )
                            }




                            Button(
                                colors = ButtonDefaults.outlinedButtonColors(
                                    backgroundColor = PrimaryColor,
                                    contentColor = SecondayColor
                                ),
                                shape = Shapes.small,
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(vertical = 11.dp)
                                    .alpha(2F)
                            ) {
                                Text("طريقة التقدم للوظيفة")
                            }


                        }
                    }
                }


            }
        }
    }


@Preview
@Composable

fun DefaultPreview11() {
    JobInfo (rememberNavController())
}
