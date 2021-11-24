package com.glomadov.example.cakeapp.ui.cake.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.glomadov.example.cakeapp.R
import com.glomadov.example.cakeapp.BR
import com.glomadov.example.cakeapp.databinding.ItemCakeVhBinding
import com.squareup.picasso.Picasso


internal class CakeVH(private val binding: ItemCakeVhBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cake: CakeVM){
        binding.apply {
            setVariable(BR.viewModel, cake)
            cakeName.text = cake.cake.name
            cakeWeight.text = "${cake.cake.weight.toString()} г."
            cakeCalories.text = "${cake.cake.calories.toString()} ккал."
            cakePrice.text = "${cake.cake.price.toString()} руб."
            Picasso.get()
                .load("http://192.168.1.67:8080/${cake.cake.image}")
                .placeholder(R.drawable.cake)
                .error(R.drawable.cake)
                .into(cakeImg)
        }
    }
}