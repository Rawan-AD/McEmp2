package sa.gov.mc.screens.login

import android.widget.EditText
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import sa.gov.mc.R
import sa.gov.mc.Screens
import sa.gov.mc.ui.theme.*
import sa.gov.mc.utility.Background

@Composable
fun OptScreen(navController: NavHostController) {
Background()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {


    Column(
        modifier = Modifier
            .fillMaxWidth()

       , verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(269.dp))
        Text(
            text = "التحقق من الهوية", style = Typography.body2
          )
//        Text(
//            text = "كود التحقق عير سليم، حاول مرة أخرى",
//            fontFamily = FontFamily(
//                Font(R.font.frutiger_roman)
//            ),
//            textAlign = TextAlign.Center,
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Normal,
//            color = Red,
//        modifier=Modifier.absolutePadding(top=12.dp,bottom=17.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.Start) {
            Text(
                "",
                modifier = Modifier
                    .size(59.dp, 56.dp)
                    .border(1.dp, Pink, shape = Shapes.small)
                    .drawBehind {

                        drawRoundRect(
                            Gray_Medium,
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }

            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                "",
                modifier = Modifier
                    .size(59.dp, 56.dp)
                    .border(1.dp, Pink, shape = Shapes.small)
                    .drawBehind {
                        drawRoundRect(
                            Gray_Medium,
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }

            )
            Spacer(modifier = Modifier.width(12.dp))
           Text(
                "",
                modifier = Modifier
                    .size(59.dp, 56.dp)
                    .border(1.dp, Pink, shape = Shapes.small)
                    .drawBehind {
                        drawRoundRect(
                            Gray_Medium,
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }

            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                "",
                modifier = Modifier
                    .size(59.dp, 56.dp)
                    .border(1.dp, Pink, shape = Shapes.small)
                    .drawBehind {
                        drawRoundRect(
                            Gray_Medium,
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }

            )

        }
            Row(verticalAlignment = Alignment.CenterVertically){
              Icon(Icons.Default.Refresh, contentDescription = "reload",    tint = Pinkish_Gray, modifier = Modifier.absolutePadding(right=15.7.dp,top=18.dp,bottom=17.dp))
            Text(
                text = "إرسال كود التحقق مرة أخرى خلال"
                      ,
                fontFamily = FontFamily(
                    Font(R.font.frutiger_roman)
                ),
                textAlign = TextAlign.Right,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Pinkish_Gray ,
                modifier=Modifier.absolutePadding(left=1.dp,right=1.dp))
                Text(
                    text = " 126 " +
                            "",
                    fontFamily = FontFamily(
                        Font(R.font.frutiger_roman)
                    ),
                    textAlign = TextAlign.Right,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = PrimaryColor)

                Text(
                    text = "ثانية" ,

                    fontFamily = FontFamily(
                        Font(R.font.frutiger_roman)
                    ),
                    textAlign = TextAlign.Right,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Pinkish_Gray,
                    modifier=Modifier.absolutePadding(left=24.dp,right=1.dp,top=18.dp,bottom=17.dp))

        }

            OutlinedButton(
                shape = shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(273.dp, 36.dp)
                    .padding(horizontal = 51.dp),
                onClick = {
                    navController.navigate(route = Screens.HomeScreen.route)
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Dark_Gray_Black,
                    contentColor = SecondayColor
                )
            ) {
                Text(text = "تحقق",style= Typography.subtitle5,color=White)
            }

    }


    }

}







@Preview
@Composable
fun defaultPreview3() {
OptScreen(rememberNavController())

}
