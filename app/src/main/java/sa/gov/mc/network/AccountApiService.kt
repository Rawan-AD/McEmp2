package sa.gov.mc.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import retrofit2.Call
import retrofit2.http.*
import android.util.Base64
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.CheckOTP
import sa.gov.mc.data.model.Login
import sa.gov.mc.data.model.LoginResponse

import java.io.File
import java.io.FileOutputStream


interface AccountApiService {
    @GET("captcha")
    suspend fun getCaptcha(): Captcha

    @POST("account/login")
   suspend fun login(@Body login: Login):LoginResponse


   @POST("account/check-otp")@Headers("device: application/json")
    fun checkOtp(@Body checkOTP: CheckOTP):Call<String>

}









