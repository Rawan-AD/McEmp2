package sa.gov.mc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.R
import sa.gov.mc.ui.theme.Bluish
import sa.gov.mc.ui.theme.Dark_Gray_Black
import sa.gov.mc.ui.theme.subtitle3

@Composable
fun VocationHeader(modifier: Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        Image(
            painterResource(id = R.drawable.group_167),
            contentDescription = null
        )
        Spacer(Modifier.width(12.6.dp))
        Text(
            "الإجازات",
            style = MaterialTheme.typography.subtitle3,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Dark_Gray_Black
        )
        Spacer(Modifier.width(8.dp))
        Text(
            "( 18.5 )",
            style = MaterialTheme.typography.subtitle3,
            fontSize = 20.sp,
            color = Bluish
        )


    }
}