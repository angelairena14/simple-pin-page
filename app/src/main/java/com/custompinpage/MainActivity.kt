package com.custompinpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.partial_custom_pin.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var counter = 0
    private var pin = StringBuilder("123456")
    private var listButton = intArrayOf(
        R.id.button_0,
        R.id.button_1,
        R.id.button_2,
        R.id.button_3,
        R.id.button_4,
        R.id.button_5,
        R.id.button_6,
        R.id.button_7,
        R.id.button_8,
        R.id.button_9,
        R.id.back_space
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_0 -> bindPin('0')
            R.id.button_1 -> bindPin('1')
            R.id.button_2 -> bindPin('2')
            R.id.button_3 -> bindPin('3')
            R.id.button_4 -> bindPin('4')
            R.id.button_5 -> bindPin('5')
            R.id.button_6 -> bindPin('6')
            R.id.button_7 -> bindPin('7')
            R.id.button_8 -> bindPin('8')
            R.id.button_9 -> bindPin('9')
            R.id.back_space -> removePin()
        }
    }

    private fun initListener() {
        for (i in listButton) findViewById<Button>(i).setOnClickListener(this)
    }

    private fun fillPin() {
        when (counter) {
            0 -> {
                counter++
                button_pin_1.setImageResource(R.drawable.ic_dot_selected)
            }
            1 -> {
                counter++
                button_pin_2.setImageResource(R.drawable.ic_dot_selected)
            }
            2 -> {
                counter++
                button_pin_3.setImageResource(R.drawable.ic_dot_selected)
            }
            3 -> {
                counter++
                button_pin_4.setImageResource(R.drawable.ic_dot_selected)
            }
            4 -> {
                counter++
                button_pin_5.setImageResource(R.drawable.ic_dot_selected)
            }
            5 -> {
                counter++
                button_pin_6.setImageResource(R.drawable.ic_dot_selected)
            }
        }
        if (counter == 6) {
            setButtonEnable(false)
            validatePin(pin.toString())
        }
    }

    private fun validatePin(pin : String){
        if (pin == "141414") {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        } else {
            Toast.makeText(this,"invalid pin!",Toast.LENGTH_SHORT).show()
            resetPin()
        }
    }

    private fun resetPin(){
        for (i in 0..6) removePin()
    }

    private fun bindPin(character: Char) {
        if (counter < 6) {
            pin.setCharAt(counter, character)
            fillPin()
        }
    }

    private fun setButtonEnable(enable: Boolean) {
        for (i in listButton) findViewById<Button>(i).isEnabled = enable
        back_space.isEnabled = true
    }

    private fun removePin() {
        when (counter) {
            6 -> {
                counter--
                button_pin_6.setImageResource(R.drawable.ic_dot)
            }
            5 -> {
                counter--
                button_pin_5.setImageResource(R.drawable.ic_dot)
            }
            4 -> {
                counter--
                button_pin_4.setImageResource(R.drawable.ic_dot)
            }
            3 -> {
                counter--
                button_pin_3.setImageResource(R.drawable.ic_dot)
            }
            2 -> {
                counter--
                button_pin_2.setImageResource(R.drawable.ic_dot)
            }
            1 -> {
                counter--
                button_pin_1.setImageResource(R.drawable.ic_dot)
            }
        }
        if (counter < 6) setButtonEnable(true)
    }
}
