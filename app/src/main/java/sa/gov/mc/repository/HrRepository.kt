package sa.gov.mc.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.CaptchaRemoteDataSource
import sa.gov.mc.data.HrRemoteDataSource
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.data.model.HR
import javax.inject.Inject

class HrRepository  @Inject constructor(
    private val chrRemoteDataSource: HrRemoteDataSource){
    lateinit var profile: HR

    suspend fun hrProfile(): HR {
        withContext(Dispatchers.IO) {
            try {
               profile = chrRemoteDataSource.getHrProfile()
                return@withContext profile

            } catch (e: Exception) {

            }
        }
        return profile

    }





}