package sa.gov.mc.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import sa.gov.mc.ui.theme.*
import androidx.navigation.NavController

@Composable
fun PageUI(
    page: Page
) {

   Column(
        modifier = Modifier
            .fillMaxSize(),

      horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Spacer(modifier = Modifier.height(278.dp))
        Box(contentAlignment = Alignment.CenterEnd){
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            modifier = Modifier.size(173.3.dp,98.9.dp))


        }

            Spacer(modifier = Modifier.height(30.1.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.alpha(0.5f)) {
                Divider(modifier = Modifier.width(209.dp), PrimaryColor, 1.dp)
                Spacer(modifier = Modifier.width(3.dp))

                Divider(modifier = Modifier.width(16.dp), PrimaryColor, 1.dp)
                Spacer(modifier = Modifier.width(2.dp))
                Divider(modifier = Modifier.width(10.dp), PrimaryColor, 1.dp)
                Spacer(modifier = Modifier.width(1.dp))
                Divider(modifier = Modifier.width(6.dp), PrimaryColor, 1.dp)


            }
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = page.title,
                textAlign = TextAlign.Center, fontSize = 24.sp,    color = Dark_Green, modifier = Modifier.absolutePadding(left=20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = page.description,
                fontSize = 38.sp, fontWeight = FontWeight.Bold,color= PrimaryColor, modifier = Modifier.absolutePadding(right=70.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))


        }

}
