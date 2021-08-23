package de.schaldrak.timerconverterlib.tools

internal fun String.toIntOrZero() = runCatching { toInt() }.getOrDefault(0)