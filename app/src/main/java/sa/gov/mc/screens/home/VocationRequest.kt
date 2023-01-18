package sa.gov.mc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import sa.gov.mc.R

import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.CardDate
import sa.gov.mc.utility.CustomButton


@Composable
fun VocationRequest(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackground)
                .padding(horizontal = 16.dp)
        ) {
            val (header, content) = createRefs()



            Spacer(Modifier.height(10.dp))
            VocationHeader(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .verticalScroll(rememberScrollState())
                    .constrainAs(content) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.fillToConstraints
                    }, horizontalAlignment = Alignment.CenterHorizontally

            ) {


                Spacer(Modifier.height(18.dp))
                Divider(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = Gray_Search
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "طلب إجازة",
                    color = Dark_Gray_Black,
                    style = MaterialTheme.typography.subtitle3,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.absolutePadding(right = 18.dp)
                )

                Spacer(Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    CardDate(title = "من تاريخ", Icons.Default.DateRange)
                    Spacer(modifier = Modifier.width(30.dp))
                    CardDate(title = "حتى تاريخ", Icons.Default.DateRange)

                }
                Spacer(Modifier.height(16.dp))
                Row(Modifier.height(40.dp), horizontalArrangement = Arrangement.Center) {
                   CustomButton("تقديم الطلب", navController,"homeScreen", modifier = Modifier.size(339.dp,39.dp),
                       Text_Gray)
                }
                Spacer(Modifier.height(17.dp))

                Divider(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = Gray_Search
                )
                Spacer(Modifier.height(14.dp))
                Text(
                    "الطلبات السابقة",
                    color = Dark_Gray_Black,
                    style = MaterialTheme.typography.subtitle3,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.absolutePadding(right = 18.dp)
                )
                Spacer(Modifier.height(19.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)

                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Spacer(Modifier.width(9.dp))
                    Text(
                        "النوع",
                        style = Typography.subtitle6,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Brown_Gray
                    )
                    Spacer(Modifier.width(54.dp))
                    Text(
                        "من",
                        style = Typography.subtitle6,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Brown_Gray
                    )
                    Spacer(Modifier.width(81.dp))
                    Text(
                        "إلى",
                        style = Typography.subtitle6,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Brown_Gray
                    )
                    Spacer(Modifier.width(76.5.dp))
                    Text(
                        "الحالة",
                        style = Typography.subtitle6,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Brown_Gray
                    )

                }
                Spacer(Modifier.height(5.dp))
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(40.dp)
                        .fillMaxWidth()
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(1) { item ->
                        Spacer(Modifier.width(15.dp))
                        Text(
                            text = "سنوية",
                            style = Typography.subtitle4,
                            textAlign = TextAlign.Justify,
                            color = Text_Gray
                        )
                        Spacer(Modifier.width(33.dp))
                        Text(
                            text = "04 يناير 2021",
                            style = Typography.subtitle4,
                            textAlign = TextAlign.Justify,
                            color = Text_Gray
                        )
                        Spacer(Modifier.width(35.dp))
                        Text(
                            text = "04 يناير 2021",
                            style = Typography.subtitle4,
                            textAlign = TextAlign.Justify,
                            color = Text_Gray
                        )
                        Spacer(Modifier.width(53.dp))
                        Image(
                            painterResource(id = R.drawable.icon_material_check_circle),
                            contentDescription = null,
                            modifier = Modifier.size(17.dp)
                        )


                    }

                }

            }
        }

    }
}