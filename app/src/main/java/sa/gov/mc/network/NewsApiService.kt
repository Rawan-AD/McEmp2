package sa.gov.mc.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

import sa.gov.mc.screens.news.New

 interface NewsApiService {


    @GET("news/public-news")
//    @Headers("token: String")
//    @Header("Authorization") token: String
    fun getAllPublicNews(): List<New>


    @GET("news/public-news/{id}")
    fun getPublicNewById():Call<New>
    @GET("news/external-news")
    fun getAllExternalNews():Call<List<New>>
@GET("news/external-news/{id}")
fun getExternalNewById():New


    @GET("news/internal-news")
    fun getAllInternalNews():List<New>


    @GET("new/internal-news/{id}")
    fun getInternalNewsById():New


    @GET("news/external-news/{id}/image/{imageId}" )
    fun getExternalNewImage():String


    @GET( "news/internal-news/{id}/image/{imageId}")
    fun getInternalNewImage():String

 }

