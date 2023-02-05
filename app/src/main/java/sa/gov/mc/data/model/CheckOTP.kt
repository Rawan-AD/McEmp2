package sa.gov.mc.data.model

data class CheckOTP(val requestId:Long,val OTP:Int ,val uuid :String)
data class OtpResponse(val token:String,val refreshToken:String)