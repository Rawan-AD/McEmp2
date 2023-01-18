package sa.gov.mc.screens.jobs

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.InternalCoroutinesApi
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.utility.AppHeader
import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.Search

@Composable
fun JobsUI(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .padding(horizontal = 10.dp)
        ){
            val (header, content, bottomBar) = createRefs()
            AppHeader("الوظائف","المتاحة",navController = navController,
                modifier = Modifier
//                    .padding(vertical = 10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },"homeScreen")

            Column(
                modifier = Modifier
                    .padding(vertical = 6.dp).fillMaxWidth().fillMaxHeight()

                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(bottomBar.top)
                        height = Dimension.fillToConstraints
                    }
                 , horizontalAlignment = Alignment.CenterHorizontally  ){

                Search("بحث")
                    Row(
                        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start

                    ) {
                        Card(
                           modifier = Modifier
                               .absolutePadding(right = 13.dp, left = 60.dp, top = 17.dp)
                               .size(143.dp, 29.dp),border= BorderStroke(1.dp, Pinkish_Gray)
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start
                            ) {
                                Text(
                                    text = "المدينة",
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.frutiger_roman)),
                                    color = Text_Gray,
                                    modifier = Modifier.absolutePadding(right=9.dp)
                                )

                                Icon(
                                    Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Text_Gray,
                                    modifier = Modifier.absolutePadding(right=44.dp)

                                )


                            }
                        }
                        Spacer(modifier = Modifier.width(50.dp))
                        Card(
                            modifier = Modifier
                                .absolutePadding( top = 17.dp,left=10.dp)
                                .size(143.dp, 29.dp), border = BorderStroke(1.dp, Pinkish_Gray)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start

//
                            ) {
                                Text(
                                    text = "حتى تاريخ",
                                    color = Text_Gray,
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.frutiger_roman)),
                                    modifier = Modifier.absolutePadding(right=9.dp)


                                    )


                                Icon(
                                    Icons.Default.DateRange,
                                    contentDescription = null,
                                    tint = Text_Gray,
                                    modifier=Modifier.absolutePadding(right=36.dp)
                                )


                            }
                        }


                    }
                    var jobsList = mutableListOf<Job>()
                for(i in 0..12){
                    jobsList.add(Job("باحث قضايا", "الرياض"))
                }




                Spacer(modifier = Modifier.height(12.dp))
                    LazyColumn() {
                        items(jobsList.size) { item ->
                            JobCard2(jobsList[item],navController)
                            Spacer(modifier = Modifier.height(6.dp))
                        }
                    }


                }

//        }




}}}

@Composable
fun JobCard2(job: Job,navController:NavController) {
    Surface(

            elevation = 4.dp,
            color = MaterialTheme.colors.surface,
            shape = Shapes.Larg_Medium,
        modifier = Modifier
            .clickable { navController.navigate(Screens.JobInfoScreen.route) }
            .fillMaxWidth()
            .size(356.dp, 76.dp)
            .padding(horizontal = 9.dp)

    ) {



        Column() {

            Text(
                text = job.title,
                fontFamily = FontFamily(Font(R.font.frutiger_bold)),
                textAlign = TextAlign.Right,
                fontSize = 14.sp,
                color = Gray_Black,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

            )
            Spacer(modifier = Modifier.height(1.dp))
            Row(
                modifier = Modifier.absolutePadding(right = 10.dp, bottom = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painterResource(id = R.drawable.department),
                    contentDescription = "department_logo",
                    modifier = Modifier
                        .absolutePadding(left = 5.dp)
                        .size(12.3.dp, 9.8.dp)
                )
                Text(
                    text = job.description,
                    fontFamily = FontFamily(Font(R.font.frutiger_roman)),
                    textAlign = TextAlign.Right,
                    fontSize = 13.sp,
                    color = Gray_Black,
                    modifier = Modifier.absolutePadding(right = 1.dp)

                )

            }}
        }
    }


@Preview
@Composable
fun defaultPreview6() {
    JobsUI(rememberNavController())
}