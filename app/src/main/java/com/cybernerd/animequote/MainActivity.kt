package com.cybernerd.animequote

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_redirect_to_quote_page.setOnClickListener {
            val intent = Intent(this, Activity_Quotes::class.java)
            startActivity(intent)
        }

        button_github.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse(""))
            startActivity(intent)
        }





    }
}