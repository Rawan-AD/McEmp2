package sa.gov.mc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sa.gov.mc.R
import sa.gov.mc.ui.theme.Brown_Gray
import sa.gov.mc.ui.theme.Gray_Search


@Composable
fun EvaluationInfo() {
    Card(Modifier.size(66.dp)){
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("الاجازات",modifier=Modifier.absolutePadding(right=12.dp),fontSize=12.sp)
            Spacer(modifier = Modifier.height(5.3.dp))
            Divider(modifier = Modifier.padding(horizontal = 10.dp), color = Gray_Search)
            Image(painterResource(id = R.drawable.pngtree_vector_element_of_business_data_graph_analytic_png_image_779763),contentDescription=null,modifier=Modifier.size(65.dp))

    }


    }}


data class Evaluation(var title:String,var image: Painter)