package com.example.userbehaviorexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class EventActivity : AppCompatActivity() {

    private lateinit var btnExplore : Button
    private lateinit var btnCheckout: Button
    private lateinit var btnLogout : Button
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        firebaseAnalytics = Firebase.analytics
        supportActionBar!!.setTitle("Event")

        val email = intent.getStringExtra("email").toString()

        btnExplore = findViewById(R.id.btn_event_explore)
        btnCheckout = findViewById(R.id.btn_event_checkout)
        btnLogout = findViewById(R.id.btn_event_logout)

        btnExplore.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putString("item", "Pants")
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
            showToast("Event explore")
        }

        btnCheckout.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putString("item", "Pants")
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.PURCHASE, bundle)
            showToast("Event Checkout")
        }

        btnLogout.setOnClickListener {
            finishAffinity()
        }
    }

    fun showToast(text : String){
        Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()
    }
}