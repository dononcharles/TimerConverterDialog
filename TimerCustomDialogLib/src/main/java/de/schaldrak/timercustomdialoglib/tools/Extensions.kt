package de.schaldrak.timercustomdialoglib.tools

internal fun String.toIntOrZero() = runCatching { toInt() }.getOrDefault(0)
internal fun String.toLongOrZero() = runCatching { toLong() }.getOrDefault(0)
internal fun String.toFloatOrZero() = runCatching { toFloat() }.getOrDefault(0F)
