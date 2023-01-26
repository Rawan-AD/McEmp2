package sa.gov.mc.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.HR
import sa.gov.mc.network.AccountApiService
import sa.gov.mc.network.HrService
import javax.inject.Inject

class HrRemoteDataSource @Inject constructor(private val api: HrService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun getHrProfile(): HR =
        withContext(dispatcher){
            api.getHrProfile()
        }
}


