package com.mcua.architecture.util.exception

class NetworkException(message: String) : Exception(message) {
    companion object {
        const val DEFAULT_MESSAGE = "You need an internet connection to perform this action."
    }

    override val message: String
        get() {
            return "No internet connection. " + super.message
        }
}