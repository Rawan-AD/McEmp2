package sa.gov.mc.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.network.AccountApiService
import javax.inject.Inject

class CaptchaRemoteDataSource @Inject constructor(private val api:AccountApiService,private val dispatcher:CoroutineDispatcher=Dispatchers.IO) {
    suspend fun getCaptcha(): Captcha =
        withContext(dispatcher){
            api.getCaptcha()
        }
}