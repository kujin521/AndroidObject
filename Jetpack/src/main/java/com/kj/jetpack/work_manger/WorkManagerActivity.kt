package com.kj.jetpack.work_manger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.kj.jetpack.R
import kotlinx.android.synthetic.main.activity_work_manager.*
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        button.setOnClickListener {
            val request=OneTimeWorkRequest.Builder(SimpleWorker::class.java)
                .setInitialDelay(5,TimeUnit.MINUTES)//设置5分钟后运行
                .addTag("simple")//添加请求标签，
                .build()
            WorkManager.getInstance(this).enqueue(request)
        }
    }
}