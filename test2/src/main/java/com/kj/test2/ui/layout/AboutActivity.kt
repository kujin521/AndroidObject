package com.kj.test2.ui.layout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.kj.test2.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        nickname_text.setOnClickListener { updateNickName(it) }

    }

    private fun updateNickName(it: View) {
        //设置视图可见性
        nickname_ed.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        it.visibility = View.GONE
        //获取焦点
        nickname_ed.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickname_ed, 0)
    }

    fun clickHandleFunction(view: View) {
        nickname_text.text= nickname_ed.text
        nickname_text.visibility=View.VISIBLE
        nickname_ed.visibility=View.GONE
        view.visibility=View.GONE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}