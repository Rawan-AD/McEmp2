package sa.gov.mc.network

import retrofit2.http.GET
import sa.gov.mc.data.model.CarLicense

interface CarLicenseService{
    @GET("car-License/get-car-License/")
    suspend fun CarLicense():List<CarLicense>
}