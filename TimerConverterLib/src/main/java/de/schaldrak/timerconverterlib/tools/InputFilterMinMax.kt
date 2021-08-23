package de.schaldrak.timerconverterlib.tools

import android.text.InputFilter
import android.text.Spanned

/**
 * @author Komi Donon
 * @since 10/14/2020.
 */
internal class InputFilterMinMax(private var min: Int, private var max: Int) : InputFilter {
    override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int, dend: Int): CharSequence? {
        try {
            if (isInRange(min, max, Integer.parseInt(dest.toString() + source.toString()))) return null
        } catch (nfe: NumberFormatException) {
            return source
        }
        return ""
    }
    private fun isInRange(a: Int, b: Int, c: Int): Boolean = if (b > a) c in a..b else c in b..a
}