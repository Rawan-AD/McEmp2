package sa.gov.mc.di

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import sa.gov.mc.EmployeeApplication


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

@Provides
fun provideContext(application: EmployeeApplication): Context {
    return application.applicationContext
}


}