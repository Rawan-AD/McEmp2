package sa.gov.mc.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.model.User
import sa.gov.mc.network.UsersApiService

class UserRemoteDateSource(private val api: UsersApiService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO){
    suspend fun userProfile(): User =
        withContext(dispatcher) {
            api.getUserProfile()
        }
}