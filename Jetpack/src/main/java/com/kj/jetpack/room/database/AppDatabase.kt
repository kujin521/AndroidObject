package com.kj.jetpack.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kj.jetpack.room.dao.UserDao
import com.kj.jetpack.room.entity.User

//定义数据库对象，数据库版本，包含的实体类
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        private var instance: AppDatabase?=null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,"app_database")
                .allowMainThreadQueries()//Room默认不容许在主线程中进行数据库操作，加入这个方法可以在主线程进行数据库操作

                .build().apply {
                    instance =this
                }
        }
    }
}
