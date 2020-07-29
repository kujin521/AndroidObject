package com.kj.jetpack.live_data.liveData_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kj.jetpack.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    val viewModel=MainViewModel(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        button2.setOnClickListener {
            val value = viewModel.counter.value?:0
            if (value<5){
                viewModel.plusOne()
            }else{
                viewModel.clear()
            }
        }

        viewModel.counter.observe(this, Observer {count->
            textView2.text = count.toString()
        })
    }
}