package com.androiddevs.mvvmnewsapp.ui.db
import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.ui.models.Article

@Dao
interface ArticleDao {
    // if a article already exists by onConflict fun it replaces the article
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //coroutines
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    //Normal fun coz it returns LIVE data objects
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}