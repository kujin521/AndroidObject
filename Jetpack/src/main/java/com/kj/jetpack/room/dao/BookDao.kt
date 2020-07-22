package com.kj.jetpack.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kj.jetpack.room.entity.Book

@Dao
interface BookDao {
    @Insert
    fun insertBook(book: Book):Long

    @Query("select * from Book")
    fun loadAllBooks(): List<Book>
}