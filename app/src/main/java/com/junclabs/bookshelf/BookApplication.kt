package com.junclabs.bookshelf

import android.app.Application
import com.junclabs.bookshelf.data.AppContainer
import com.junclabs.bookshelf.data.DefaultAppContainer

class BookApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}