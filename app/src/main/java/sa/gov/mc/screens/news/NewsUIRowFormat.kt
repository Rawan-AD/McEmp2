package sa.gov.mc.screens.news

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.ui.theme.*
import sa.gov.mc.R
import sa.gov.mc.utility.AppBar
import sa.gov.mc.utility.Search

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewsUIRowFormat (){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground).verticalScroll(rememberScrollState()),

        content = {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Column(modifier = Modifier.padding(9.dp)) {
//                    AppBar("أخبار", "الوزارة")
                    Search(title = "بحث")
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(Modifier.horizontalScroll(rememberScrollState())) {
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
                        Spacer(modifier = Modifier.width(31.dp))
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
                                                              
                     Spacer(modifier = Modifier.height(18.dp))
                    Card(modifier = Modifier.fillMaxSize(), backgroundColor = White) {


                                    Row(Modifier.fillMaxWidth().absolutePadding(right=8.dp,top=12.dp,left=7.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                        column_news()

                                        Spacer(modifier = Modifier.width(10.dp))
                                        column_news()

                                    }


                            }

                    }
                }
      
        },
    )}


                       @Composable
                    fun column_news()  {
                        Column{
                            Image(painterResource(id = R.drawable.box), contentDescription = null,
                                Modifier
                                    .size(163.dp, 132.dp)
                                    .clip(
                                        (Shapes.ExtraMedium)
                                    ))
                            Spacer(modifier = Modifier.height(6.dp))
                                Text(text="«التجارة»: لا يحق للمتاجر تخزين"+ "\n" +"المواد الغذائية لرفع سعرها.. أو فرض قيود على بيعها",style=typography.subtitle4,color= Brown_Gray,modifier=Modifier.size(163.dp,54.dp),lineHeight = 21.sp

                                )
                        }
                    }







@Composable
fun news_row_ui(width: Dp, height:Dp, color:Color, title:String)    {
    Row(modifier= Modifier
        .absolutePadding(left = 6.dp) , verticalAlignment = Alignment.CenterVertically    ){
       Card(shape= Shapes.Larg_Medium,modifier = Modifier
          
           .size(width, height), border= BorderStroke(1.dp, Gray_Medium),backgroundColor = color) {
                 Text(text =title,style=typography.subtitle3, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
       }
    }
}

@Preview
@Composable
 fun defaultPreview15() {
NewsUIRowFormat ()  }
