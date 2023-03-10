package sa.gov.mc.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import retrofit2.Call
import retrofit2.http.*
import android.util.Base64
import kotlinx.coroutines.flow.Flow
import sa.gov.mc.data.model.*

import java.io.File
import java.io.FileOutputStream


interface AccountApiService {
    @GET("captcha")
    suspend fun getCaptcha(): Captcha

    @POST("account/login")
   suspend fun login(@Body login: Login): LoginResponse
//   @GET("account/login")
//   suspend fun getLogin():LoginResponse

   @POST("account/check-otp")@Headers("device: application/json")
    fun checkOtp(@Body checkOTP: CheckOTP):OtpResponse


    @POST("account/check-otp")
    suspend fun refreshToken(@Body token: RefreshToken):TokenResponse

    @POST("account/resend-otp")
    suspend fun resendOtp(@Body uuid: UUID):LoginResponse
}









