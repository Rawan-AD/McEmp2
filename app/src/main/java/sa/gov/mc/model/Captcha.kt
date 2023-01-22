package sa.gov.mc.model



data class Captcha( val captcha: String,
    val uuid:String)


data class Login(val username:String,val password:String,val uuid :String,val answer:String)

data class LoginResponse (val requestId:Long,val uuid:String)
data class CheckOTP(val requestId:Long,val OTP:String ,val uuid :String)

