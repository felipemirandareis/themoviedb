package com.mirandafelipe.themoviedb

import android.app.Application
import com.mirandafelipe.data.di.DataStoreModule
import com.mirandafelipe.data.di.DatabaseModule
import com.mirandafelipe.data.di.NetworkModule
import com.mirandafelipe.data.di.RepositoryModule
import com.mirandafelipe.domain.di.DomainModule
import com.mirandafelipe.themoviedb.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TMDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TMDBApplication)
            modules(
                PresentationModule.module,
                DomainModule.module,
                RepositoryModule.module,
                DatabaseModule.module,
                NetworkModule.module,
                DataStoreModule.module
            )
        }
    }
}