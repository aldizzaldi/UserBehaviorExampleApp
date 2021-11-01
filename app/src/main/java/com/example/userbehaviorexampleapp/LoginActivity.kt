package com.example.userbehaviorexampleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class LoginActivity: AppCompatActivity() {

    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAnalytics = Firebase.analytics
        supportActionBar!!.setTitle("Login")

        etEmail = findViewById(R.id.et_email_login)
        etPassword = findViewById(R.id.et_password_login)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()

            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putString("password", password)
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, bundle)
            Toast.makeText(applicationContext,"Login berhasil", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, EventActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}