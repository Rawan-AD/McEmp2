package sa.gov.mc.network

import retrofit2.http.GET
import sa.gov.mc.data.model.HR


interface HrService {
    @GET("hr/profile")
    suspend fun getHrProfile(): HR



    //dont sure about return type
    @GET("hr/absences-dashboards")
    suspend fun getAbsences(): HR


    @GET("hr/absences-history")
    suspend fun getAbsencesHistory():HR


    @GET("hr/appraisals-history")
    suspend fun getAppraisalsHistory():HR

}