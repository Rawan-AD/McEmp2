package sa.gov.mc.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.CheckOTP
import sa.gov.mc.data.model.OtpResponse
import sa.gov.mc.network.AccountApiService
import javax.inject.Inject

class CheckOtpRemoteDataSource  @Inject constructor(private val api: AccountApiService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun checkOtp(): OtpResponse=
        withContext(dispatcher){
            api.checkOtp(CheckOTP(912,1234,"fffffffffffffff"))
        }
}