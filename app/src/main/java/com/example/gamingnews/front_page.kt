package com.example.gamingnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class front_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@front_page,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)




    }

}