package de.schaldrak.timerconverterlib

import android.app.Activity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.google.android.material.textfield.TextInputEditText
import de.schaldrak.timerconverterlib.tools.InputFilterMinMax
import de.schaldrak.timerconverterlib.tools.toIntOrZero

/**
 * @author Komi Donon <dononcharles@gmail.com>
 * @since 8/10/2021.
 * <doc>This class is a custom timer dialog to return hours or minutes in seconds</doc>
 */
data class STimerDialog(private val activity: Activity) {

    /**
     * @param presetInputValue:Int
     */
    fun customTimerSet(presetInputValue: Int, positiveCallback: (hourInSecond: Int, minuteInSecond: Int, second: Int) -> Unit) {
        val materialDialog = MaterialDialog(activity).show {
            title(R.string.set_time)
            customView(R.layout.timer_custom_dialog)
            cancelOnTouchOutside(false)
            negativeButton(R.string.cancel) { }
            positiveButton(R.string.set) { dialog ->
                val hourInSecond = dialog.findViewById<TextInputEditText>(R.id.hourTIet).text.toString().toIntOrZero() * activity.resources.getInteger(R.integer.HOUR_SECOND_CONSTANT)
                val minuteInSecond = dialog.findViewById<TextInputEditText>(R.id.minuteTIet).text.toString().toIntOrZero() * activity.resources.getInteger(R.integer.SECOND_CONSTANT)
                val second = dialog.findViewById<TextInputEditText>(R.id.secondTIet).text.toString().toIntOrZero()
                positiveCallback(hourInSecond, minuteInSecond, second)
            }
        }

        val s = materialDialog.findViewById<TextInputEditText>(R.id.secondTIet)
        s.filters = arrayOf(InputFilterMinMax(0, activity.resources.getInteger(R.integer.SECOND_CONSTANT_MINUS_ONE)))

        val m = materialDialog.findViewById<TextInputEditText>(R.id.minuteTIet)
        m.filters = arrayOf(InputFilterMinMax(0, activity.resources.getInteger(R.integer.SECOND_CONSTANT_MINUS_ONE)))

        val h = materialDialog.findViewById<TextInputEditText>(R.id.hourTIet)
        h.filters = arrayOf(InputFilterMinMax(0, 23))

        val second = presetInputValue % activity.resources.getInteger(R.integer.SECOND_CONSTANT)
        val minute = presetInputValue % activity.resources.getInteger(R.integer.HOUR_SECOND_CONSTANT) / activity.resources.getInteger(R.integer.SECOND_CONSTANT)
        if (minute >= 0) {
            val hour = presetInputValue / activity.resources.getInteger(R.integer.HOUR_SECOND_CONSTANT)
            s.setText(second.toString())
            m.setText(minute.toString())
            h.setText(hour.toString())
        } else {
            s.setText(second.toString())
            m.setText(minute.toString())
        }
    }
}
