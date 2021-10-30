package com.example.userbehaviorexampleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SignupActivity: AppCompatActivity() {
//
//    private val firebaseAuth = FirebaseAuth.getInstance()
//    private val firebaseFirestore = FirebaseFirestore.getInstance()

    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnSignup : Button
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        firebaseAnalytics = Firebase.analytics

        etEmail = findViewById(R.id.et_email_signup)
        etPassword = findViewById(R.id.et_password_signup)
        btnSignup = findViewById(R.id.btn_signup)

        btnSignup.setOnClickListener {
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()

            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putString("password", password)
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle)
            Toast.makeText(applicationContext,"Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}