package de.schaldrak.timerconverterdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import de.schaldrak.timerconverterlib.STimerDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondField = findViewById<TextInputEditText>(R.id.secondTimerTiet)
        secondField.apply {
            setOnClickListener {
                STimerDialog(this@MainActivity).customTimerSet(presetInputValue = this.text.toString().toIntOrZero()) { hInSecond, mInSecond, second ->
                    this.setText((hInSecond + mInSecond + second).toString())
                }
            }
        }
    }
}

internal fun String.toIntOrZero() = runCatching { toInt() }.getOrDefault(0)