package com.samar.feedsystem.utils

class ErrorHandler {
    fun handleError(e: Exception) {
        Logger.log("Error occurred: ${e.message}")
        throw RuntimeException("Internal Server Error")
    }
}
