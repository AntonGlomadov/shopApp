package com.glomadov.example.cakeapp.ui.cake.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.glomadov.example.cakeapp.databinding.FragmentCakeListBinding
import com.glomadov.example.cakeapp.ui.cake.list.adapter.CakeAdapter

class CakesFragment : Fragment() {
    private lateinit var binding: FragmentCakeListBinding
    private val cakeAdapter = CakeAdapter()
    private val cakesVM: CakesVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCakeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cakeList.apply {
            adapter = cakeAdapter
            layoutManager = GridLayoutManager(context,2)
        }

        cakesVM.getCakes().observe(viewLifecycleOwner){
            cakeAdapter.reload(it)
        }

    }
}