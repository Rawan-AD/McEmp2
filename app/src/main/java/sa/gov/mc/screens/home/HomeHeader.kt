package sa.gov.mc.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import sa.gov.mc.R
import sa.gov.mc.ui.theme.Dark_Blue_Green
import sa.gov.mc.ui.theme.Orange
import sa.gov.mc.ui.theme.PrimaryColor
import sa.gov.mc.ui.theme.Shapes

@Composable
fun HomeHeader(modifier: Modifier) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
    ) {
        Row(
            Modifier.absolutePadding(17.dp, 15.dp, 27.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "مرحباً",
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(
                    Font(R.font.frutiger_bold)
                ), color = Dark_Blue_Green
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "تركي الشهراني",
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray,
                fontFamily = FontFamily(
                    Font(R.font.frutiger_bold)
                )
            )

            Spacer(modifier = Modifier.width(3.dp))


            Icon(
                Icons.Default.Star,
                contentDescription = null,
                tint = Orange,
                modifier = Modifier
                    .size(12.dp)
                    .absolutePadding(top = 2.dp)
            )



            Spacer(modifier = Modifier.width(80.dp))

            Box(
                modifier = Modifier
                    .clip(Shapes.medium)
                    .background(color = PrimaryColor)
                    .width(70.dp)
                    .padding(5.dp),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = "حضور",
                    textAlign = TextAlign.Center,
                    color = Color.White,

                    )
            }
        }


    }
}