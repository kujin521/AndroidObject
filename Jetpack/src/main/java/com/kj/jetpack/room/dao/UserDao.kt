package com.kj.jetpack.room.dao

import androidx.room.*
import com.kj.jetpack.room.entity.User

//数据访问对象
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertUser(user: User):Long

    @Update
    fun upDateUser(newUser:User)

    @Delete
    fun delete(user: User)

    @Query("delete from User where last_name=:lastName")
    fun deleteUserByLastName(lastName: String): Int
}