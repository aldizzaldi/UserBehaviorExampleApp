package com.example.userbehaviorexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics

class EventActivity : AppCompatActivity() {

    private lateinit var btnExplore : Button
    private lateinit var btnCheckout: Button
    private lateinit var btnLogout : Button
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        val email = intent.getStringExtra("email").toString()

        btnExplore = findViewById(R.id.btn_event_explore)
        btnCheckout = findViewById(R.id.btn_event_checkout)
        btnLogout = findViewById(R.id.btn_event_logout)

        btnExplore.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("email", email)
//            firebaseAnalytics.logEvent(FirebaseAnalytics.Event., bundle)
            showToast("Event explore")
        }

        btnCheckout.setOnClickListener {
            showToast("Event Checkout")
        }

        btnLogout.setOnClickListener {
            finish()
        }
    }

    fun showToast(text : String){
        Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()
    }
}