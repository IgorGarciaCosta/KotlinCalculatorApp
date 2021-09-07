package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastNumeric:Boolean = false
    var lastDot:Boolean = false
    var lastOperator:Boolean = false
    var firstOperator:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        tvInput.append((view as Button).text)
        lastNumeric = true
        lastOperator = false
    }

    fun onClear(view: View){
        tvInput.text = ""
        lastNumeric = false
        lastDot = false
        lastOperator = false
    }

    fun onDecimalPoint(view: View){
        if(lastNumeric&&!lastDot){
            tvInput.append((view as Button).text)
            lastNumeric =false
            lastDot =true
            lastOperator = false
        }
    }

    fun onOperatorPoint(view: View){
        if(tvInput.length()==0){
            if((view as Button).text=="-"){
                tvInput.append((view as Button).text)
                lastOperator = true
                lastDot = false
                lastNumeric = false
            }
        }
        else if(!lastOperator){

            tvInput.append((view as Button).text)
            lastOperator = true
            lastDot = false
            lastNumeric = false
        }
    }

    fun onEqual(view: View){
        
    }


}