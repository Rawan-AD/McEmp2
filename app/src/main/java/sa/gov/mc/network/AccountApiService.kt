package sa.gov.mc.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import retrofit2.Call
import retrofit2.http.*
import android.util.Base64
import sa.gov.mc.data.model.*

import java.io.File
import java.io.FileOutputStream


interface AccountApiService {
    @GET("captcha")
    suspend fun getCaptcha(): Captcha

    @POST("account/login")
   suspend fun login(@Body login: Login):LoginResponse


   @POST("account/check-otp")@Headers("device: application/json")
    fun checkOtp(@Body checkOTP: CheckOTP):Call<String>


    @POST("account/check-otp")
    suspend fun checkOtp(@Body login: Login):TokenResponse

    @POST("account/resend-otp")
    suspend fun resendOtp(@Body uuid: String):LoginResponse
}









