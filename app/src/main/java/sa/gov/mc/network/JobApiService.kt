package sa.gov.mc.network

import retrofit2.http.GET
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.EmployeeJob
import sa.gov.mc.data.model.Job

interface JobApiService {

    @GET("jobs/get-available-jobs")
    suspend fun getAvailableJobs(): List<Job>

    @GET("jobs/get-employee-jobs")
    suspend fun getEmployeeJobs(): List<EmployeeJob>

}