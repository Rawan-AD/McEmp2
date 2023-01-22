package sa.gov.mc.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import retrofit2.Call
import retrofit2.http.*
import android.util.Base64
import sa.gov.mc.model.Captcha
import sa.gov.mc.model.CheckOTP
import sa.gov.mc.model.Login
import sa.gov.mc.model.LoginResponse

import java.io.File
import java.io.FileOutputStream


interface AccountApiService {
    @GET("captcha")
    suspend fun getCaptcha():Captcha

    @POST("account/login")
    fun postLogin(@Body login: Login):Call<LoginResponse>


   @POST("account/check-otp")@Headers("device: application/json")
    fun checkOtp(@Body checkOTP: CheckOTP ):Call<String>

}








fun Decode_Base64(i: String) {

    val decodedString: ByteArray = Base64.decode(i, Base64.DEFAULT)
    // Bitmap Image
    // Bitmap Image
    val bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

    val filename = "MyImage.png"
    val file: File = Environment.getExternalStorageDirectory()
    val dest = File(file, filename)

    try {
        val out = FileOutputStream(dest)
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, out)
        out.flush()
        out.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}