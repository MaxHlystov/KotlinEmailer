package com.example.max.emailer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.send_mail_activity.*

class SendMailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.send_mail_activity)
        val msg: String = intent.getStringExtra(SEND_EMAIL)
        textPreview.text = msg
        btn_email.setOnClickListener {
            val i = getMailIntent(getString(R.string.HelloSubject), msg)
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i)
            } else {
                Toast.makeText(this, getString(R.string.NoEmail), Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        private val SEND_EMAIL = "SEND_EMAIL"

        fun startActivity(parent: Activity, msg: String) {
            val i = Intent(parent, SendMailActivity::class.java)
            i.putExtra(SEND_EMAIL, msg)
            parent.startActivity(i)
        }

        private fun getMailIntent(subject: String, msg: String): Intent {
            val i = Intent(Intent.ACTION_SENDTO)
            val mailto = "mailto:?subject=$subject&body=$msg"
            i.data = Uri.parse(mailto)
            return i
        }
    }
}