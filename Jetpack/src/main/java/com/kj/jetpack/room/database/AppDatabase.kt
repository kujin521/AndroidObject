package com.kj.jetpack.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kj.jetpack.room.dao.BookDao
import com.kj.jetpack.room.dao.UserDao
import com.kj.jetpack.room.entity.Book
import com.kj.jetpack.room.entity.User

//定义数据库对象，数据库版本，包含的实体类
@Database(version = 2, entities = [User::class,Book::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao

    companion object{
        private var instance: AppDatabase?=null

        val MIGRATION_1_2=object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book (" +
                        "id integer primary key autoincrement not null," +
                        "name text not null," +
                        "pages integer not null)")
            }
        }

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,"app_database")
                .allowMainThreadQueries()//Room默认不容许在主线程中进行数据库操作，加入这个方法可以在主线程进行数据库操作
                .addMigrations(MIGRATION_1_2)//添加数据表
                .build().apply {
                    instance =this
                }
        }
    }
}
