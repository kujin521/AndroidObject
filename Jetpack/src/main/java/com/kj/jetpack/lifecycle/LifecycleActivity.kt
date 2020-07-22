package com.kj.jetpack.lifecycle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kj.jetpack.R

class LifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        //监听生命周期
        MyObserver(lifecycle)
        val currentState = lifecycle.currentState
        Toast.makeText(this, ""+currentState, Toast.LENGTH_SHORT).show()

    }


}