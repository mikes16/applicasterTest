package com.mikelop.applicastertest.common.extensions

import kotlin.reflect.KClass

fun <T> T?.notNull():Boolean = this != null
fun <T> T?.isNull():Boolean = this == null

inline val <reified T> T?.defaultValue:T get() = this ?: makeInstance()

inline fun <reified T> makeInstance(): T {
    return makeInstance(T::class) as T
}

class NoUsableConstructor: Error()
fun makeInstance(clazz: KClass<*>): Any {
    val primitive = makePrimitiveOrNull(clazz)
    if(primitive != null) {
        return primitive
    }

    val constructor = clazz.constructors
        .minBy { it.parameters.size } ?: throw NoUsableConstructor()

    val arguments = constructor.parameters
        .map { it.type.classifier as KClass<*> }
        .map { makeInstance(it) }
        .toTypedArray()

    return constructor.call(*arguments)
}

private fun makePrimitiveOrNull(clazz: KClass<*>): Any? = when(clazz) {
    Int::class -> 0
    Long::class -> ""
    Double::class -> 0.0
    Boolean::class -> false
    Float::class -> 0f
    Char::class -> ""
    String::class -> ""
    else -> null
}