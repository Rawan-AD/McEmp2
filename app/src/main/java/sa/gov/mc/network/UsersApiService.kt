package sa.gov.mc.network

import retrofit2.http.GET
import sa.gov.mc.data.model.User

interface UsersApiService{
    @GET("user/profile")
    suspend fun getUserProfile(): User
}