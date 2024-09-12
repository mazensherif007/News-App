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

        binding?.healthPic?.setOnClickListener{
            onClickHealth()
        }

        binding?.environmentPic?.setOnClickListener{
            onClickEnvironment()
        }

        binding?.politicsPic?.setOnClickListener{
            onClickPolitics()
        }

        binding?.businessPic?.setOnClickListener{
            onClickBusiness()
        }

        binding?.sciencePic?.setOnClickListener{
            onClickScience()
        }


    }

    private fun onClickScience() {
        val intent = Intent(this, ActivityNews::class.java)
        intent.putExtra("category", "science")
        startActivity(intent)
    }

    private fun onClickBusiness() {
        val intent = Intent(this, ActivityNews::class.java)
        intent.putExtra("category", "business")
        startActivity(intent)
    }

    private fun onClickPolitics() {
        val intent = Intent(this, ActivityNews::class.java)
        intent.putExtra("category", "entertainment")
        startActivity(intent)
    }

    private fun onClickEnvironment() {
        val intent = Intent(this, ActivityNews::class.java)
        intent.putExtra("category", "general")
        startActivity(intent)
    }

    private fun onClickHealth() {
        val intent = Intent(this, ActivityNews::class.java)
        intent.putExtra("category", "health")
        startActivity(intent)
    }

    private fun onClickSports() {
        val intent = Intent(this, ActivityNews::class.java)
        intent.putExtra("category", "sports")
        startActivity(intent)
    }


}