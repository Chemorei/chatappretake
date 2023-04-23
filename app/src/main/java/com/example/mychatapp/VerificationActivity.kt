package com.example.mychatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import com.example.mychatapp.databinding.ActivityOtpactivityBinding
import com.google.firebase.auth.FirebaseAuth

class VerificationActivity : AppCompatActivity() {
    var binding : ActivityOtpactivityBinding? = null
    var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser != null){
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        supportActionBar!!.hide()
        binding!!.otpview.requestFocus()
        binding!!.continueBtn01.setOnClickListener {
            val intent = Intent(this,OTPActivity::class.java)
            intent.putExtra("phoneNumber",binding!!.otpview.text.toString())
            startActivity(intent)
        }
    }
}