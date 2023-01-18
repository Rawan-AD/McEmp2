package sa.gov.mc.utility

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.ui.theme.*

@Composable
fun Search(title:String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = Shapes.ExtraMedium)
, backgroundColor = Gray_Search
    ) {
        Row {
            Text(
                text =title,
                fontFamily = frutiger,
                textAlign = TextAlign.Right,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Medium_Gray,
                modifier = Modifier.padding(horizontal = 9.dp, vertical = 10.dp)
            )

            Icon(
                Icons.Default.Search,
                contentDescription = "search_icon",
                tint = Dark_Gray_Black,
                modifier = Modifier.absolutePadding(10.dp, 10.dp, 312.dp)
            )
        }

    }
}



