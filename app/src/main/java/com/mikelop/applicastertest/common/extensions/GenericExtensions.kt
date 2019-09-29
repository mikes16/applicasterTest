package com.mikelop.applicastertest.common.extensions

fun <T> T?.notNull():Boolean = this != null
fun <T> T?.isNull():Boolean = this == null