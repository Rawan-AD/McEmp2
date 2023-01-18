package sa.gov.mc.screens.news


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import sa.gov.mc.R

import sa.gov.mc.ui.theme.GrayBackground
import sa.gov.mc.ui.theme.Gray_Medium

import sa.gov.mc.utility.*



@Composable
fun NewsUI(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .padding(horizontal = 10.dp)
        ) {
            val (header, content, bottomBar) = createRefs()

            AppHeader("أخبار","الوزارة",navController = navController,
                modifier = Modifier
//                    .padding(vertical = 10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },"homeScreen")



         Column(  modifier = Modifier
             .fillMaxWidth()
             .padding(vertical = 6.dp)

             .constrainAs(content) {
                 top.linkTo(header.bottom)
                 start.linkTo(parent.start)
                 end.linkTo(parent.end)
                 bottom.linkTo(bottomBar.top)
                 height = Dimension.fillToConstraints
             },)
 {


                    Search(title = "بحث")
                    Spacer(modifier = Modifier.height(10.dp))
                   Row(
                        Modifier
                            .fillMaxWidth()

                            .padding(horizontal = 9.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        news_row_ui(width = 54.dp, height = 27.dp, color = White, title = "الكل")
                        Spacer(modifier = Modifier.width(10.dp))
                        news_row_ui(
                            width = 105.dp,
                            height = 27.dp,
                            color = Gray_Medium,
                            title = "التستر"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        news_row_ui(
                            width = 105.dp,
                            height = 27.dp,
                            color = Gray_Medium,
                            title = "الصحف الدولية"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painterResource(id = R.drawable.icon_awesome_sort_amount_down_alt),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(15.dp))
                        Image(
                            painterResource(id = R.drawable.component_75___1),
                            contentDescription = null
                        )


                    }

                    LazyRow(Modifier.absolutePadding(right = 9.dp, left = 17.dp, top = 14.dp)) {


                    }

                    var newsList = mutableListOf<New>()

                    for (i in 0..14) {
                        newsList.add(
                            New(
                                painterResource(R.drawable.person),
                                "فلان الفلان الفلاني",
                                "مساك الله بالخير"
                            )
                        )
                    }

                    LazyColumn(modifier = Modifier.padding(horizontal = 9.dp)) {
                        items(newsList.size) { item ->
                            NewCard(newsList[item],navController)
                            Spacer(Modifier.height(9.dp))
                        }
                    }


                }



        }
    }
}
@Preview
@Composable
fun defaultPreview10() {
    NewsUI(rememberNavController())
}