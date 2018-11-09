package com.mantul.foodsaver

import AppPref
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (!AppPref.getInstance(applicationContext).getBoolean(AppPref.PrefKey.IS_LOGIN_KEY)) {
            openLoginScreen()
            finish()
        }
    }

    private fun openLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
