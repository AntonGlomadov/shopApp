package com.glomadov.example.cakeapp

import android.app.Application

class App: Application() {
    lateinit var mainRouter: MainRouter
    override fun onCreate() {
        super.onCreate()
    }
}