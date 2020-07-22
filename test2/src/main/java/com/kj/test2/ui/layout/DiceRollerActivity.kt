package com.kj.test2.ui.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kj.test2.R
//自动关联id
import kotlinx.android.synthetic.main.activity_dice_roller.*

class DiceRollerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        //点击事件
        roll_button.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val randomInt=(1..6).random()
        result_text.text=randomInt.toString()
    }
}