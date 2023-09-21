package com.aidios.energizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        UI_Enhancer.hideSystemUI(this)
    }

    fun bulogin(view: View) {
        val intent : Intent = Intent(this,home::class.java)
        startActivity(intent)
        finish()
    }
}