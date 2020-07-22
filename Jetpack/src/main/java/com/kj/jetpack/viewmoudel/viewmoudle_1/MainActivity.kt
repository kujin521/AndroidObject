
package com.kj.scoreviewmodel.viewmoudel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.kj.jetpack.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //定义viewmodel
    lateinit var viewModel: MainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //初始化viewmodel
        viewModel= ViewModelProviders.of(this).get(MainModel::class.java)

        //button点击事件
        plusOnBtn.setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }
        refreshCounter()

    }
    //更新视图
    private fun refreshCounter() {
        infoText.text=viewModel.counter.toString()
    }
}
