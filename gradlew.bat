package com.example.factortestapp

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    var randomFactor: Int = 0
    var factorArray : ArrayList<Int> = ArrayList<Int>()
    var score: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        setInvisible()

        goBtn.setOnClickListener {
            hideKeyboard()
            if (enteredNo.text.trim().isNotEmpty()){
                setVisible()
                factorArray = factor(enteredNo.text.toString().toInt())
                randomFactor = factorArray[(0 until factorArray.size-1).random()]
                val randomBtn = (1..3).random()
                when(randomBtn){
                    1 -> {
                        opt1Btn.setText(randomFactor.toString())
                        opt2Btn.text = randomOption(randomFactor)
                        opt3Btn.text = randomOption(randomFactor)
                    }
                    2 -> {
                        opt1Btn.text = randomOption(randomFactor)
                        opt2Btn.setText(randomFactor.toString())
                        opt3Btn.text = randomOption(randomFactor)
                    }
                    3 -> {
                        opt1Btn.text = randomOption(randomFactor)
                        opt2Btn.text = randomOption(randomFactor)
                        opt3Btn.setText(randomFactor.toString())
                    }
                }
            }else {
                Toast.makeText(this@GameActivity, "Enter a number", Toast.LENGTH_SHORT).show()
            }
        }

        opt1Btn.setOnClickListener {
            if (opt1Btn.text == randomFactor.toString()){
                myRespo