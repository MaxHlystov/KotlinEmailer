package com.example.max.emailer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_preview.setOnClickListener {
            val msg = tv_msg.text.toString()
            if(!msg.isEmpty()) {
                SendMailActivity.startActivity(this, msg)
            } else {
                Toast.makeText(this, getString(R.string.NothinToPreview), Toast.LENGTH_LONG).show()
            }
        }
    }
}
