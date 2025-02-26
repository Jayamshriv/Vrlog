package com.example.vrlog.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vrlog.data.local.entity.BlogsPostItemModelEntity
import com.example.vrlog.data.local.dao.BlogsPostDao

@Database(entities = [BlogsPostItemModelEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun blogsDataDao(): BlogsPostDao
}