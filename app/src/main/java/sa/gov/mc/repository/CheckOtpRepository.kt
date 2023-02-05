package sa.gov.mc.repository

import android.annotation.SuppressLint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.CaptchaRemoteDataSource
import sa.gov.mc.data.CheckOtpRemoteDataSource
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.CheckOTP
import sa.gov.mc.data.model.OtpResponse
import javax.inject.Inject

class CheckOtpRepository @Inject constructor(
    private val checkOtpRemoteDataSource: CheckOtpRemoteDataSource
) {

    lateinit var otp: OtpResponse


    @SuppressLint("SuspiciousIndentation")
    suspend fun checkOtp():OtpResponse {
        withContext(Dispatchers.IO) {
            try {
            otp= checkOtpRemoteDataSource.checkOtp()
                return@withContext otp

            } catch (e: Exception) {

            }
        }
        return otp

    }
}