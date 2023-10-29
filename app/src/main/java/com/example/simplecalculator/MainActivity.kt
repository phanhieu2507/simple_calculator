package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    var currentNumber = ""
    var numbers = mutableListOf<Double>()
    var operators = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
    }

    fun clearAllOnClick(view: View) {
        numbers.clear()
        operators.clear()
        currentNumber = ""
        textView.text = "0"
    }

    fun clearEntryOnClick(view: View) {
        currentNumber = ""
        textView.text = "0"
    }

    fun backspaceOnClick(view: View) {
        if (currentNumber.length > 1) {
            currentNumber = currentNumber.dropLast(1)
            textView.text = currentNumber
        } else {
            currentNumber = ""
            textView.text= "0"

        }

    }

    fun zeroOnClick(view: View) {
        currentNumber += "0"
        textView.text = currentNumber
    }

    fun oneOnClick(view: View) {
        currentNumber += "1"
        textView.text = currentNumber
    }

    fun twoOnClick(view: View) {
        currentNumber += "2"
        textView.text = currentNumber
    }

    fun threeOnClick(view: View) {
        currentNumber += "3"
        textView.text = currentNumber
    }

    fun fourOnClick(view: View) {
        currentNumber += "4"
        textView.text = currentNumber
    }

    fun fiveOnClick(view: View) {
        currentNumber += "5"
        textView.text = currentNumber
    }

    fun sixOnClick(view: View) {
        currentNumber += "6"
        textView.text = currentNumber
    }

    fun sevenOnClick(view: View) {
        currentNumber += "7"
        textView.text = currentNumber
    }

    fun eightOnClick(view: View) {
        currentNumber += "8"
        textView.text = currentNumber
    }

    fun nineOnClick(view: View) {
        currentNumber += "9"
        textView.text = currentNumber
    }

    fun additionOnClick(view: View) {
        try {
            numbers.add(currentNumber.toDouble())
            operators.add("+")
            currentNumber = ""
            textView.text = "0"
        } catch (e: NumberFormatException) {
            textView.text = "Error"
        }
    }

    fun divisionOnClick(view: View) {
        try {
            numbers.add(currentNumber.toDouble())
            operators.add("/")
            currentNumber = ""
            textView.text = "0"
        } catch (e: NumberFormatException) {
            textView.text = "Error"
        }
    }

    fun multiplicationOnClick(view: View) {
        try {
            numbers.add(currentNumber.toDouble())
            operators.add("*")
            currentNumber = ""
            textView.text = "0"
        } catch (e: NumberFormatException) {
            textView.text = "Error"
        }
    }

    fun subtractionOnClick(view: View) {
        try {
            numbers.add(currentNumber.toDouble())
            operators.add("-")
            currentNumber = ""
            textView.text = "0"
        } catch (e: NumberFormatException) {
            textView.text = "Error"
        }
    }

    fun negativeOnClick(view: View) {
        if (currentNumber.isNotEmpty()) {
            if (currentNumber.startsWith("-")) {
                currentNumber = currentNumber.substring(1)
            } else {
                currentNumber = "-$currentNumber"
            }

            textView.text = currentNumber
        }
    }

    fun dotOnClick(view: View) {
        // Xử lý khi ấn nút dấu chấm
    }

    fun equalOnClick(view: View) {
        try {
            numbers.add(currentNumber.toDouble())

            var result = numbers[0]
            for (i in 0 until operators.size) {
                when (operators[i]) {
                    "+" -> result += numbers[i + 1]
                    "-" -> result -= numbers[i + 1]
                    "*" -> result *= numbers[i + 1]
                    "/" -> result /= numbers[i + 1]
                }
            }

            val resultText: String = if (result == result.toInt().toDouble()) {
                result.toInt().toString()
            } else {
                String.format("%.2f", result)
            }

            textView.text = resultText
        } catch (e: Exception) {
            textView.text = "Error"
        }
    }

}
