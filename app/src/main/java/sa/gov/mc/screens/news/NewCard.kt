package sa.gov.mc.utility

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import sa.gov.mc.Screens
import sa.gov.mc.screens.news.New
import sa.gov.mc.ui.theme.ExtraSmall
import sa.gov.mc.ui.theme.Shapes
import sa.gov.mc.ui.theme.subtitle3
import sa.gov.mc.ui.theme.subtitle4


var flag=0
@Composable
fun NewCard (new: New,navController: NavController){
 Card(Modifier
            .fillMaxWidth().size(356.dp, 76.dp).clickable { navController.navigate( Screens.News.route)
                                                          flag= 1},
        shape = Shapes.ExtraSmall, backgroundColor = Color.White

    ) {
        Row() {
            Image(
                new.image, contentDescription = null, contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxHeight().width(68.dp).absolutePadding(top=11.dp,right=10.dp,bottom=10.dp)

            )

            Column(
                modifier = Modifier
                    .absolutePadding(top = 11.dp,right=9.dp,bottom=4.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text("«التجارة»: لا يحق للمتاجر تخزين المواد الغذائية"
                      , style = typography.subtitle4)
                Text("27 جمادى الثانية 1443 هـ",
                        fontSize = 10.sp,  style =typography.subtitle3, modifier = Modifier.absolutePadding(right=14.dp))
            }
        }}}



