package sa.gov.mc.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import sa.gov.mc.R
import sa.gov.mc.utility.CardFactory

@Composable
fun EmployeeInfo() {
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CardFactory(
            width = 35.3.dp,
            height = 35.2.dp,
            painterResource(id = R.drawable.layer_2),
            "تهانينا ",
            "تركي",
            "تقييم ادائك ممتاز",

            null
        )

        Spacer(Modifier.width(19.dp))
        CardFactory(
            width = 39.dp,
            height = 35.3.dp,
            painterResource(id = R.drawable.group_135),
            "رصيد اجازات",
            " 18 ",
            "يوم",
            painterResource(id = R.drawable.ic_baseline_more_vert_24)
        )


    }
}