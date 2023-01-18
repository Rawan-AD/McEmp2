package sa.gov.mc.utility

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.R
import sa.gov.mc.ui.theme.Beige
import sa.gov.mc.ui.theme.ExtraExtraSmall
import sa.gov.mc.ui.theme.Shapes
import sa.gov.mc.ui.theme.Text_Gray

@Composable
fun CardDate(title: String,image: ImageVector) {
    Card(
        modifier = Modifier

            .size(143.dp, 29.dp)

            .clip(Shapes.ExtraExtraSmall), border = BorderStroke(1.dp, Beige)
    ) {
        Row(
            modifier = Modifier.absolutePadding(right = 7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Text_Gray,
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.frutiger_roman)),
                modifier = Modifier.absolutePadding(right = 7.dp)
            )
//            Spacer(modifier = Modifier.width(12.dp))


            Icon(
                image,
                contentDescription = null,
                tint = Text_Gray,
                modifier = Modifier.absolutePadding(right = 46.dp)
            )


        }


    }
}