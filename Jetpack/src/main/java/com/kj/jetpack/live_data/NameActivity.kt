package com.kj.jetpack.live_data

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kj.jetpack.R
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    // 使用'by viewModels()' Kotlin属性委托
    // 来自activity-ktx工件
    private val model: NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        // 创建用于更新UI的观察者。
        val nameObserver = Observer<String> { newName ->
            // 更新UI，这里是TextView。
            nameTextView.text = newName
        }

        // 观察LiveData，将此活动作为LifecycleOwner和observer传递进来。
        model.currentName.observe(this, nameObserver)

        // 修改参数
        updateBtn.setOnClickListener {
            model.currentName.setValue(edText.text.toString())
            //model.currentName.postValue(edText.text.toString())
        }

    }
}