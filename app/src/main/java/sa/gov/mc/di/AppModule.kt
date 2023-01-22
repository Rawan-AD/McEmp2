package sa.gov.mc.di

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit.Builder {



        return Retrofit.Builder()
    }


}