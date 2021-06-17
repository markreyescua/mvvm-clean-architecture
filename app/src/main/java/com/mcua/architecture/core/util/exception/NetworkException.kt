package com.mcua.architecture.core.util.exception

class NetworkException(message: String? = null) : Exception(message) {
    companion object {
        const val DEFAULT_MESSAGE = "You need an internet connection to perform this action."
    }

    override val message: String
        get() {
            return super.message ?: DEFAULT_MESSAGE
        }
}