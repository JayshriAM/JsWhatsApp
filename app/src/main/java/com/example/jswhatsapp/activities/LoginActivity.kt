package com.example.jswhatsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jswhatsapp.MainActivity
import com.example.jswhatsapp.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()

        loginScreen_signupBtn.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginScreen_loginBtn.setOnClickListener {view->
            if (loginScreen_email.text.trim().length!=0 && loginScreen_password.text.trim().length!=0){
                LoginToFireBase(loginScreen_email.text.toString(), loginScreen_password.text.toString())
            }else{
                Snackbar.make(view, "Enter all the details.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }

    fun LoginToFireBase (email: String, password:String){
        mAuth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext,"Successful Login", Toast.LENGTH_LONG).show()
                    LoadMain()
                } else {
                    Toast.makeText(applicationContext,"Login Failed", Toast.LENGTH_LONG).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        LoadMain()
    }

    fun LoadMain(){
        var currentUser = mAuth!!.currentUser

        if (currentUser!=null){
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", currentUser.email)
            intent.putExtra("uid", currentUser.uid)

            startActivity(intent)

        }
    }
}
