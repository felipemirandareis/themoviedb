package com.mirandafelipe.data

sealed class ErrorException : Throwable() {
    object BadException : ErrorException()
}