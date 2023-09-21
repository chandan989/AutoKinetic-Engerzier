package com.aidios.energizer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        UI_Enhancer.hideSystemUI(this)

        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this, Login::class.java)
            startActivity(mainIntent)
            finish()
        }, 500)

    }
}