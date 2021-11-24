package com.glomadov.example.cakeapp.ui.cake.fullinfo

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.glomadov.example.cakeapp.R
import com.glomadov.example.cakeapp.data.storage.StorageNetData
import com.glomadov.example.cakeapp.model.CakeFullInfo
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch


@BindingAdapter("app:picasso")
fun image(view: ImageView, path: String?) {
    Picasso.get().load("http://192.168.1.67:8080/${path}").placeholder(R.drawable.cake)
        .error(R.drawable.cake)
        .into(view)
}

class CakeDetailVM(application: Application) : AndroidViewModel(application) {
    private var cakeDetail = CakeFullInfo.emptyCakeDetail()
    private val storeRepositoryNet = StorageNetData()


    fun loadData(id: Long){
        viewModelScope.launch {
            cakeDetail = storeRepositoryNet.cake(id)
            cakeDetail.run{
                nameObs.set(name)
                caloriesObs.set(calories.toString())
                imgObs.set(image)
                priceObs.set(price.toString())
                weightObs.set(weight.toString())
                compositionObs.set(composition)
                storageConditionsObs.set(storageConditions)
            }
        }
    }

    val nameObs = object : ObservableField<String>(){
        override fun get(): String?{
            return cakeDetail.name
        }
    }

    val caloriesObs = object : ObservableField<String>(){
        override fun get(): String? {
            return "${cakeDetail.calories.toString()} ккал."
        }
    }

    val imgObs = object : ObservableField<String>(){
        override fun get(): String?{
            return cakeDetail.image
        }
    }

    val priceObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${cakeDetail.price.toString()} руб."
        }
    }

    val weightObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${cakeDetail.weight.toString()} г."
        }
    }

    val compositionObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "Состав:\n${cakeDetail.composition}"
        }
    }

    val storageConditionsObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "Условия хранения:\n${cakeDetail.storageConditions}"
        }
    }

}