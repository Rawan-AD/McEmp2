package sa.gov.mc.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.screens.home.DividerFactory

import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.AppBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun EmpCard(navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

    Scaffold(
        backgroundColor = GrayBackground,
        topBar = { AppBar(title = "بطاقة", subTitle = "الموظف",navController,"homeScreen")},

        content = {
            Column(
                Modifier

                .fillMaxSize()

                    .absolutePadding(left = 9.dp, right = 9.dp)
            ) {
                Spacer(Modifier.height(5.dp))
                Card(
                    elevation = 6.dp,
                    shape = Shapes.ExtraMedium, modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Spacer(Modifier.height(15.dp))
                        Card(shape= RoundedCornerShape(40.dp)){
                        Image(
                            painterResource(id = R.drawable.person),
                            contentDescription = null,
                            Modifier
                                .clip(
                                    CircleShape
                                ).border(1.dp, White, CircleShape)
                                .size(140.dp),
                            contentScale = ContentScale.Crop
                        )}
                        Spacer(Modifier.height(12.dp))
                        Text(
                            "تركي محمد الشهراني",
                            style = typography.body2,
                            color = Dark_Green,
                            fontFamily = frutiger,
                            fontWeight = Bold,
                        )
                        Text("مطور تطبيقات", style = typography.body2, color = PrimaryColor)
                        Spacer(Modifier.height(18.dp))
                        DividerFactory()
                        _emp_row_factory(title = "الإدارة", description = "وكالة التطوير التقني")
                        Spacer(Modifier.height(16.dp))
                        DividerFactory()
                        _image_row_factory(
                            title = "الرقم الوظيفي",
                            description = "1234",
                            painter = painterResource(id = R.drawable.ic_copy)
                        )
                        Spacer(Modifier.height(11.dp))
                        DividerFactory()
                        _emp_row_factory(title = "التحويلة الداخلية", description = "1234")
                        Spacer(Modifier.height(11.dp))
                        DividerFactory()
                        Spacer(Modifier.height(18.dp))
                        Image(
                            painterResource(id = R.drawable.mc_website),
                            contentDescription = null
                        )
                        Spacer(Modifier.height(21.dp))
//                        Image(
//                            painterResource(id = R.drawable.add_to_apple_wallet_logo),
//                            contentDescription = null
//                        )
                    }
                }
            }
        }

    )}}



@Composable
fun _emp_row_factory(title:String,description:String){
Row(modifier=Modifier.absolutePadding(top=11.dp)){
    Text(title,style= typography.subtitle5,color=Dark_Gray_Black)
    Spacer(modifier = Modifier.width(12.dp))
    Text(description,style= typography.body1,color=Dark_Gray_Black,fontWeight=Bold)
}
}
@Composable
fun _image_row_factory(title:String,description:String,painter: Painter){
    Row( verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        Text(title,style= typography.subtitle5,color=Dark_Gray_Black)
        Spacer(modifier = Modifier.width(12.dp))
        Text(description,style= typography.body1,color=Dark_Gray_Black,fontWeight=Bold)
        Spacer(modifier = Modifier.width(14.dp))
        Image(painter, contentDescription =null , modifier = Modifier.size(10.dp,11.dp))
    }
}
@Preview
@Composable
fun DefaultPreview13() {
//    EmpCard()
}