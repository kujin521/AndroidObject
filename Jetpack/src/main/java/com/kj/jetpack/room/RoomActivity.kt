package com.kj.jetpack.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kj.jetpack.R
import com.kj.jetpack.room.database.AppDatabase
import com.kj.jetpack.room.entity.User
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val userDao= AppDatabase.getDatabase(this).userDao()

        addBtn.setOnClickListener {
            userDao.insertUser(User(edText.text.toString().split(" ")[0],edText.text.toString().split(" ")[1]))
        }

        updateBtn.setOnClickListener {
            userDao.upDateUser(User(edText.text.toString().split(" ")[0],edText.text.toString().split(" ")[1]))
        }

        deleteBtn.setOnClickListener {
            userDao.deleteUserByLastName(textView.text.toString())
        }

        queryBtn.setOnClickListener {
            var str=""
            for (user in userDao.getAll()){
                str+=user.toString()+"\n"
            }
            textView.text=str
        }
    }
}