package de.schaldrak.timercustomdialoglib.tools

internal fun String.toIntOrZero() = runCatching { toInt() }.getOrDefault(0)