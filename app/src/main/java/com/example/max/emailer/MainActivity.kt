package com.example.max.emailer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

val MSG_TEXT_1: String = "MSG_TEXT_1"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_preview.setOnClickListener {
            val msg = tv_msg.text.toString()
            if(!msg.isEmpty()) {
                val i = Intent(this, SendMailActivity::class.java)
                i.putExtra(MSG_TEXT_1, msg)
                startActivity(i)
            }
        }
    }
}
