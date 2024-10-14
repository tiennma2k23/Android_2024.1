package com.example.happybirthday

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var isNewOp = true
    private var operator = ""
    private var oldNumber = ""
    private var isDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
    }

    fun numberEvent(view: View) {
        if (isNewOp) {
            tvResult.text = ""
        }
        isNewOp = false

        val buClick = tvResult.text.toString()
        val buSelect = (view as Button).text.toString()

        if (buSelect == ".") {
            if (!isDot) {
                isDot = true
                tvResult.append(".")
            }
        } else {
            tvResult.append(buSelect)
        }
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = tvResult.text.toString()
        operator = (view as Button).text.toString()
        isDot = false
    }

    fun equalEvent(view: View) {
        val newNumber = tvResult.text.toString()
        var finalNumber: Double? = null
        when (operator) {
            "/" -> finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            "x" -> finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            "-" -> finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            "+" -> finalNumber = oldNumber.toDouble() + newNumber.toDouble()
        }
        tvResult.text = finalNumber.toString()
        isNewOp = true
    }

    fun clearEvent(view: View) {
        tvResult.text = "0"
        isNewOp = true
        isDot = false
    }

    fun backspaceEvent(view: View) {
        var number = tvResult.text.toString()
        if (number.isNotEmpty()) {
            number = number.substring(0, number.length - 1)
            tvResult.text = number
        }
    }

    fun plusMinusEvent(view: View) {
        val number = tvResult.text.toString().toDouble()
        tvResult.text = (number * -1).toString()
    }
}
