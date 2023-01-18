package sa.gov.mc.ui.theme

import androidx.compose.foundation.layout.size
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.R

val frutiger = FontFamily(
    listOf(
      Font(R.font.frutiger_light, FontWeight.Light),
        Font(R.font.frutiger_light, FontWeight.Normal),
        Font(R.font.frutiger_light, FontWeight.Medium),
        Font(R.font.frutiger_bold, FontWeight.SemiBold),
        Font(R.font.frutiger_bold, FontWeight.Bold),
        Font(R.font.frutiger_black, FontWeight.Black),
    )
)



val Typography = Typography(
    h1 = TextStyle(
        fontFamily = frutiger
        ,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 40.sp
    ),
    h2 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Black,
        fontSize = 32.sp
    ),
    h3 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp,
        color= Pinkish_Gray
    ),
    body1 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Black
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.frutiger_roman)),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = PrimaryColor,

    ),

    button = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = SecondayColor
    ),
    subtitle1 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Light,
        fontSize = 32.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = frutiger,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Dark_Gray_Black
    )


)



@get:Composable
val Typography.subtitle3: TextStyle
get()=TextStyle(
    fontFamily = frutiger,
    textAlign=TextAlign.Left,
    fontWeight = FontWeight.Light,
    fontSize = 13.sp,
    color = Text_Gray
)

@get:Composable
val Typography.subtitle5: TextStyle
    get()=TextStyle(
        fontFamily = FontFamily(
            Font(R.font.frutiger_roman)),
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        color = Brown_Gray
    )

@get:Composable
val Typography.subtitle4: TextStyle
    get()=TextStyle(
        fontFamily = FontFamily(
            Font(R.font.frutiger_roman)),
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Right,
        fontSize = 13.sp,
        color = Gray_Black
    )

@get:Composable
val Typography.subtitle6: TextStyle
    get()= TextStyle(
fontFamily = frutiger,
fontWeight = FontWeight.Light,
fontSize = 15.sp,
color= Pinkish_Gray)