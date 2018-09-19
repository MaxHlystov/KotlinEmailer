package com.example.max.emailer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.send_mail_activity.*

class SendMailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_mail_activity)
        val msg: String = intent.getStringExtra(MSG_TEXT_1)
        textPreview.text = msg
        btn_email.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.data = Uri.parse("mailto:")
            //i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, msg)
            i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.HelloSubject))
            if(i.resolveActivity(packageManager) != null) {
                startActivity(i)
            }
            else {
                Toast.makeText(this, getString(R.string.NoEmail), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
    }
}