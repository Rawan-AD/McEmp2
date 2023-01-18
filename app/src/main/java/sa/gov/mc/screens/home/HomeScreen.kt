package sa.gov.mc.screens.home


import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import sa.gov.mc.R
import sa.gov.mc.ui.theme.*


@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {


    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    var currentBottomSheet: BottomSheetScreen? by remember {
        mutableStateOf(null)
    }






    if (scaffoldState.bottomSheetState.isCollapsed)
        currentBottomSheet = null

    // to set the current sheet to null when the bottom sheet closes
    if (scaffoldState.bottomSheetState.isCollapsed)
        currentBottomSheet = null


    val closeSheet: () -> Unit = {
        scope.launch {
            scaffoldState.bottomSheetState.collapse()

        }
    }


    val openSheet: (BottomSheetScreen) -> Unit = {
        scope.launch {
            currentBottomSheet = it
            scaffoldState.bottomSheetState.expand()
        }

    }

    BottomSheetScaffold(sheetPeekHeight = 0.5.dp, scaffoldState = scaffoldState,
        sheetShape = BottomSheetShape,
        sheetContent = {
            currentBottomSheet?.let { currentSheet ->
                SheetLayout(currentSheet, closeSheet, navController)
            }
        }) { paddingValues ->

        val pagerState = rememberPagerState()





        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(GrayBackground)
                    .padding(horizontal = 10.dp)
            ) {
                val (header, content, bottomBar) = createRefs()


                HomeHeader(
                    modifier = Modifier

                        .constrainAs(header) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })

                Column(
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

                    ) {


                    Spacer(modifier = Modifier.height(20.dp))


                    var list: ArrayList<Home> = ArrayList()
      for(i in 1..3){
          list.add(Home("", painterResource(id = R.drawable.logo)))

      }
                    HomeAnnouncement(list, pagerState)



                    Spacer(Modifier.height(27.dp))
                    EmployeeInfo()




                    Spacer(Modifier.height(30.dp))


                    var serviceList = mutableListOf<Home>()
                    serviceList.add(
                        Home(
                            "طلب إجازة",
                            painterResource(id = R.drawable.vocation)
                        )
                    )
                    serviceList.add(
                        Home(
                            "الوظائف",
                            painterResource(id = R.drawable.attend_person)
                        )
                    )
                    serviceList.add(
                        Home(
                            "طلب صيانة",
                            painterResource(id = R.drawable.maintinance)
                        )
                    )
                    serviceList.add(
                        Home(
                            "تصريح سيارة",
                            painterResource(id = R.drawable.car)
                        )
                    )

                    HomeServices(serviceList, openSheet, navController)


                    var newsList = mutableListOf<Home>()
                    newsList.add(
                        Home(
                            "«التجارة»: لا يحق للمتاجر تخزين المواد الغذائية لرفع سعرها.. أو فرض قيود على بيعها",
                            painterResource(id = R.drawable.box)
                        )
                    )
                    newsList.add(
                        Home(
                            "«التجارة»: لا يحق للمتاجر تخزين المواد الغذائية لرفع سعرها.. أو فرض قيود على بيعها",
                            painterResource(id = R.drawable.box)
                        )
                    )
                    newsList.add(
                        Home(
                            "«ضبط مشهور يسوق منتجات مغشوشة في شقق فاخرة ويوصلها بسيارات فارهة\n" +
                                    "\n",
                            painterResource(id = R.drawable.perfume)
                        )
                    )
                    Spacer(modifier = Modifier.height(35.dp))
                    HomeNews(newsList = newsList, navController = navController)



                    Spacer(Modifier.height(22.dp))
                    var newEmployees = mutableListOf<Home>()
                    for(i in 0..3){   newEmployees.add(
                        Home(
                            "تركي الشهراني",
                            painterResource(id = R.drawable.employee)
                        )
                    )}




                    GreatingEmployees(newEmployees = newEmployees)

                }

            }


        }

    }


}


@Preview
@Composable
fun DefaultPreview4() {
    HomeScreen(navController = rememberNavController())
}


@Composable
fun TextWithShadow(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        color = DarkGray,
        modifier = modifier
            .offset(
                x = 1.dp,
                y = 1.dp
            )
            .alpha(0.75f), fontSize = 8.sp
    )
    Text(
        text = text,
        color = White,
        modifier = modifier, fontSize = 8.sp

    )
}



