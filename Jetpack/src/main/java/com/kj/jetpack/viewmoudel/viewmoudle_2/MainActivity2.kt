
package com.kj.scoreviewmodel.viewmoudel

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.kj.jetpack.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity2 : AppCompatActivity() {

    lateinit var viewModel: MainModel2
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp=getPreferences(Context.MODE_PRIVATE)
        val countReserved=sp.getInt("count_reserved",0)

        //初始化viewmodel
        viewModel= ViewModelProviders.of(this,
            MainViewModelFactory(countReserved)
        ).get(MainModel2::class.java)

        //button点击事件
        plusOnBtn.setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }
        refreshCounter()
    }

    override fun onPause() {
        super.onPause()
        sp.edit().putInt("count_reserved",viewModel.counter).apply()
    }

    //更新视图
    private fun refreshCounter() {
        infoText.text=viewModel.counter.toString()
    }
}
