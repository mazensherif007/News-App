package com.example.newsapp.ui

import android.content.Intent
import android.os.Bundle
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.ui.base.BaseActivity
import com.example.newsapp.ui.fragments.ActivityNews

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.sportsPic?.setOnClickListener{
            onClickSports()
        }

    }

    private fun onClickSports() {
        val intent = Intent(this, ActivityNews::class.java)
        startActivity(intent)
    }


}