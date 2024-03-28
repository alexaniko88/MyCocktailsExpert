package com.example.mycocktailsexpert

import android.app.Application
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import com.example.mycocktailsexpert.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


val LocalNavController = compositionLocalOf<NavController> { error("No NavController provided") }

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}