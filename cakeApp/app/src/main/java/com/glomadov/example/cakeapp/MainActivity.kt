package com.glomadov.example.cakeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.glomadov.example.cakeapp.databinding.ActivityMainBinding
import com.glomadov.example.cakeapp.ui.cake.list.CakesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).mainRouter = MainRouter(supportFragmentManager)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportFragmentManager.beginTransaction().replace(R.id.full_content, CakesFragment()).commit()
    }
}