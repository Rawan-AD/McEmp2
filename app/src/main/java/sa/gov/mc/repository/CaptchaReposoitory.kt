package sa.gov.mc.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.CaptchaRemoteDataSource
import sa.gov.mc.data.model.Captcha
import javax.inject.Inject

class CaptchaRepository @Inject constructor(
    private val captchaRemoteDataSource: CaptchaRemoteDataSource
) {

    suspend fun captchaLogin(): Captcha {
        withContext(Dispatchers.IO) {
            try {
                val captcha = captchaRemoteDataSource.getCaptcha()
                return@withContext captcha

            } catch (e: Exception) {
            }
        }
return Captcha("","")

    }
}

