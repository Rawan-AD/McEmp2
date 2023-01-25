package sa.gov.mc.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sa.gov.mc.network.NewsApiService
import sa.gov.mc.screens.news.New

class NewsRemoteDataSource(private val api: NewsApiService, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun allPublicNews():List<New> =
        withContext(dispatcher) {api.getAllPublicNews()

        }
    suspend fun allExternalNews():List<New> =
        withContext(dispatcher) {api.getAllInternalNews()

        }

    suspend fun ExternalNewById():New=
        withContext(dispatcher) {api.getExternalNewById()

        }


    suspend fun InternalNewById():New=
        withContext(dispatcher) {
            api.getInternalNewsById()

        }


    suspend fun AllInternalNews():List<New> =
        withContext(dispatcher) {
            api.getAllInternalNews()

        }

    suspend fun InternalNewsImage():String=
        withContext(dispatcher) {
            api.getInternalNewImage()

        }

    suspend fun ExternalNewsImage():String=
        withContext(dispatcher) {
            api.getExternalNewImage()

        }

}



