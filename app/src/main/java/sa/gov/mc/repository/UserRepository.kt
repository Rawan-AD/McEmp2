package sa.gov.mc.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.NewsRemoteDataSource
import sa.gov.mc.data.UserRemoteDateSource
import sa.gov.mc.data.model.User
import sa.gov.mc.screens.news.New
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDataSource: UserRemoteDateSource) {

    lateinit var user: User

    suspend fun userProfile():User{
        withContext(Dispatchers.IO) {
            try {
               user = userDataSource.userProfile()
                return@withContext user

            } catch (e: Exception) {

            }
        }
        return user

    }



}