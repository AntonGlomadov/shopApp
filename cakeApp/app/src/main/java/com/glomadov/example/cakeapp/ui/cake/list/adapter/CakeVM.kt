package com.glomadov.example.cakeapp.ui.cake.list.adapter

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import com.glomadov.example.cakeapp.App
import com.glomadov.example.cakeapp.model.Cake
import com.glomadov.example.cakeapp.ui.cake.fullinfo.CakeDetailFragment

class CakeVM(application: Application, val cake: Cake) : AndroidViewModel(application) {
    fun onClick(){
        val cakeDetailFragment = CakeDetailFragment()
        val bundle = Bundle()
        bundle.putLong("ARG_CAKE_ID", cake.id ?: 1)
        cakeDetailFragment.arguments = bundle
        getApplication<App>().mainRouter.changeMainFragment(cakeDetailFragment)
    }
}