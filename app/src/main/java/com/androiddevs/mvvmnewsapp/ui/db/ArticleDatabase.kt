package com.androiddevs.mvvmnewsapp.ui.db

import android.content.Context
import androidx.room.*
import com.androiddevs.mvvmnewsapp.ui.models.Article

@Database(
    entities = [Article::class],
    version = 1

)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase(){
    abstract fun getArticleDao(): ArticleDao


    //singleton
    companion object{
        //creating the instance of ArticleDB
        @Volatile //Means other threads can see the changes when a thread changes its instance
        private var instance: ArticleDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            //BLOCK can be accessed by other threads same time
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()


        }
}
