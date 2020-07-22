package com.kj.jetpack.work_manger

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWorker(context: Context,params: WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        //耗时操作
        Log.d("SimpleWorker", "doWork: do work in SimpleWorker")
        return Result.success()
    }
}