package com.example.newsapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsapp.api.model.ArticlesItem
import com.example.newsapp.databinding.ItemNewsBinding

class NewsAdapter(var articles: List<ArticlesItem?>): Adapter<NewsAdapter.NewsHolder>() {

    class NewsHolder(val binding: ItemNewsBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(binding)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val article = articles[position]
        holder.binding.newsTitleTv.text = article?.title
        holder.binding.newsDateTv.text = article?.publishedAt
        holder.binding.newsSourceTv.text = article?.author.toString()
        Glide.with(holder.binding.root)
            .load(article?.urlToImage)
            .into(holder.binding.newsImage)
    }

    fun submitAdapter(newArticle: List<ArticlesItem?>){
        articles = newArticle
        notifyDataSetChanged()
    }
}