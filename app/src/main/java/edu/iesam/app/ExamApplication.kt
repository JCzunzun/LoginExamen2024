package edu.iesam.app

import android.app.Application
import edu.iesam.app.di.AppModule
import edu.iesam.loginexam1eval.di.LoginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ExamApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ExamApplication)
            modules(AppModule().module,
                LoginModule().module)
        }
    }
}