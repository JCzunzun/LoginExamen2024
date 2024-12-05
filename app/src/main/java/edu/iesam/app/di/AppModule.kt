package edu.iesam.app.di

import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("edu.iesam")
class AppModule {
    @Single
    fun provideGson()=Gson()
}