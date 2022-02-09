package com.androiddevs.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.ui.respository.NewsRepository

class NewsViewModelProviderFactory (
    //Adding the parameteres
        val newsRepository : NewsRepository
        ):ViewModelProvider.Factory {
    //creating the implimenting the create function
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}