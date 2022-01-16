package com.wolf.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonAction(view: android.view.View) {
        var enterData = findViewById<EditText>(R.id.etEnterData)
        var entryData = enterData.text.toString()
        val buttonSelected = view as Button
        var number:String = entryData
        if (newOp == true){
            enterData.setText("")
        }
        newOp = false
        when(buttonSelected.id){
            R.id.bu0 -> number += "0"
            R.id.bu1 -> number += "1"
            R.id.bu2 -> number += "2"
            R.id.bu3 -> number += "3"
            R.id.bu4 -> number += "4"
            R.id.bu5 -> number += "5"
            R.id.bu6 -> number += "6"
            R.id.bu7 -> number += "7"
            R.id.bu8 -> number += "8"
            R.id.bu9 -> number += "9"
            R.id.buDot -> number += "."
            R.id.buPM -> number = "-$buttonSelected"
        }

        enterData.setText(number)

    }

    var op = "*"
    var firstNum = ""
    var newOp = true
    fun ButtonOpEvent(view: android.view.View) {
        var enterData = findViewById<EditText>(R.id.etEnterData)
        var entryData = enterData.text.toString()
        val buttonSelected = view as Button
        var number:String = entryData
        when(buttonSelected.id) {
            R.id.buMultiply ->{
                op = "*"
            }
            R.id.buDivide -> {
                op = "/"
            }
            R.id.buAdd ->{
                op = "+"
            }
            R.id.buMod ->{
                op = "%"
            }
            R.id.buMinus ->{
                op = "-"
            }
        }

        firstNum = entryData.toString()
        newOp = true
    }

    fun ButtonEqEvent(view: android.view.View) {
        var total = findViewById<EditText>(R.id.etEnterData)
        var newNumber = total.text.toString()
        var totals:Double? = null
        when(op){
            "*" ->{
                totals = firstNum.toDouble() * newNumber.toDouble()
            }
            "+" ->{
                totals = firstNum.toDouble() + newNumber.toDouble()
            }
            "-" ->{
                totals = firstNum.toDouble() - newNumber.toDouble()
            }
            "/" ->{
                totals = firstNum.toDouble() / newNumber.toDouble()
            }
            "%" ->{
                totals = firstNum.toDouble() % newNumber.toDouble()
            }
        }

        total.setText(totals.toString())
        newOp = true
    }
}