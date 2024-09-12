package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.NewsAdapter
import com.example.newsapp.api.ApiManager
import com.example.newsapp.api.model.SourcesItem
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.ui.base.BaseActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.coroutines.launch

class ActivityNews: BaseActivity<ActivityNewsBinding>() {

    private lateinit var adapter : NewsAdapter

    override fun inflateBinding() = ActivityNewsBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSources()
        initRecyclerView()
        onTabClick()
    }

    private fun initRecyclerView(){
        adapter = NewsAdapter(emptyList())
        binding!!.newsRecycler.adapter = adapter
    }

    private fun onTabClick() {
        binding!!.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                getArticles(tab?.tag as String)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                getArticles(tab?.tag as String)
            }
        })
    }

    private fun getArticles(tadId: String) {
        showLoading()
        hideError()
        lifecycleScope.launch {
            try {
                val response = ApiManager.webService().getArticles(tabId = tadId)
                adapter.submitAdapter(response.articles!!)
                hideLoading()
            } catch (e: Exception) {
                showError(e.message.toString()) {
                    getArticles(tadId)
                }
            }
        }
    }

    private fun getSources() {
        showLoading()
        hideError()
        lifecycleScope.launch {
            try {
                val response = ApiManager.webService().getSources(category = selectedImage())
                showTabs(response.sources)
                hideLoading()
            } catch (e: Exception) {
                showError(e.message.toString()){
                    getSources()
                }
            }
        }
    }

    private fun selectedImage(): String {
        when (val selectedImage = intent.getStringExtra("category")) {
            "science" -> {
                return "science"
            }
            "business" -> {
                return "business"
            }
            "entertainment" -> {
                return "entertainment"
            }
            "general" -> {
                return "general"
            }
            "health" -> {
                return "health"
            }
            "sports" -> {
                return "sports"
            }
            else -> return selectedImage.toString()
        }

    }

    private fun showTabs(sources: List<SourcesItem?>?) {
        for (source in sources!!) {
            val tab = binding?.tabLayout?.newTab()
            tab?.text = source?.name
            tab?.tag = source?.id
            binding?.tabLayout!!.addTab(tab!!)
        }
    }

    private fun showError(errorMessage: String, onRetryClick: () -> Unit) {
        binding!!.errorView.root.visibility = View.VISIBLE
        binding!!.errorView.errorText.text = errorMessage
        binding!!.errorView.retryBtn.setOnClickListener{
            onRetryClick()
        }
    }

    private fun hideError() {
        binding!!.errorView.root.visibility = View.GONE
    }

    private fun showLoading(){
        binding!!.looder.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding!!.looder.visibility = View.GONE
    }

}