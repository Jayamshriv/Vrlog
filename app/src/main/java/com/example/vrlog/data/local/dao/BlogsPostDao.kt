package com.example.vrlog.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vrlog.data.local.entity.BlogsPostItemModelEntity


@Dao
interface BlogsPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlogs(data : List<BlogsPostItemModelEntity>)

    @Query("SELECT * FROM posts")
    suspend fun getAllPosts() : List<BlogsPostItemModelEntity>

    @Query("DELETE FROM posts")
    suspend fun deleteAll()

}