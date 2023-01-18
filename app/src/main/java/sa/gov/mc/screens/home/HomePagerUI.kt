package sa.gov.mc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.R


@Composable
fun   HomePagerUI(home: Home) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painterResource(id = R.drawable.mc_logo_full_white),
            contentDescription = "mc_logo",
            modifier = Modifier.size(120.dp,120.dp)
        )
Spacer(modifier = Modifier.width(17.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Spacer(modifier = Modifier.height(.dp))
            Text(text = "تم تغيير روابط الوزارة إلى ", color = Color.White,fontSize=14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "https://MC.gov.sa", color = Color.White, fontSize = 14.sp,fontWeight = FontWeight.Bold)
        }
    }
}