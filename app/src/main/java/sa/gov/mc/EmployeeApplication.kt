package sa.gov.mc

import android.app.Application
import android.content.res.Configuration
import android.media.VolumeShaper

import dagger.hilt.android.HiltAndroidApp
import java.io.Closeable


@HiltAndroidApp
class EmployeeApplication: Application(), Closeable {
    override fun close() {
        TODO("Not yet implemented")
    }



}