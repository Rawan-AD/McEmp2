package sa.gov.mc.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import sa.gov.mc.data.model.AttendanceRequest

interface AttendanceService {
// response two type error and string
    @POST("attendance/login")
    suspend fun postAttendance(@Body attendance: AttendanceRequest):String

//get user data
    @GET("attendance/detail")
    //dont sure for return error
    suspend fun postAttendance():Error


}
