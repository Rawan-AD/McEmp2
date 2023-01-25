package sa.gov.mc.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.data.LoginRemoteDataSource
import sa.gov.mc.data.NewsRemoteDataSource
import sa.gov.mc.data.model.Captcha
import sa.gov.mc.screens.news.New
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource) {

    lateinit var news: List<New>

    suspend fun allPublicNews(): List<New> {
        withContext(Dispatchers.IO) {
            try {
                news = newsRemoteDataSource.allPublicNews()
                return@withContext news

            } catch (e: Exception) {

            }
        }
        return news

    }






}