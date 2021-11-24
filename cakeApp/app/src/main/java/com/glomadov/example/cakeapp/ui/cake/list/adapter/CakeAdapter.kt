package com.glomadov.example.cakeapp.ui.cake.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glomadov.example.cakeapp.databinding.ItemCakeVhBinding

internal class CakeAdapter : RecyclerView.Adapter<CakeVH>() {

    private var cakes = mutableListOf<CakeVM>()

    fun reload(newCakes: List<CakeVM>){
        cakes.clear()
        cakes.addAll(newCakes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeVH {
        val inflater = LayoutInflater.from(parent.context)
        return CakeVH(ItemCakeVhBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CakeVH, position: Int) {
        holder.bind(cakes[position])
    }

    override fun getItemCount(): Int = cakes.size
}