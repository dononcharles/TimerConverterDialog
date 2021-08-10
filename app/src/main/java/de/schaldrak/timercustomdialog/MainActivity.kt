package de.schaldrak.timercustomdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import de.schaldrak.timercustomdialoglib.STimerDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondField = findViewById<TextInputEditText>(R.id.secondTimerTiet)
        secondField.apply {
            setOnClickListener {
                STimerDialog(this@MainActivity).customTimerSet(presetInputValue = this.text.toString().toInt()) { hInSecond, mInSecond, second ->
                    this.setText((hInSecond + mInSecond + second).toString())
                }
            }
        }
    }
}