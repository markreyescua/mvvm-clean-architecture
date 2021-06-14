package com.mcua.architecture.core.util.network

import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import timber.log.Timber
import java.io.EOFException
import java.io.IOException

class RetrofitException internal constructor(
    private val retrofit: Retrofit?,
    private val response: Response<*>?,
    private val kind: Kind,
    val url: String?,
    message: String?,
    exception: Throwable?,
) : RuntimeException(message, exception) {

    /**
     * Identifies the event kind which triggered a [RetrofitException].
     */
    enum class Kind {
        NETWORK,
        HTTP,
        UNEXPECTED
    }

    inner class ErrorResponse(
        @SerializedName("message") val message: String?,
        @SerializedName("error") val error: String?,
        @SerializedName("error_description") val errorDescription: String?,
        @SerializedName("result") val result: Map<String, String>?
    )

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.
     *
     * @throws IOException if unable to convert the body to the specified `type`.
     */
    @Throws(IOException::class)
    fun <T> getErrorBodyAs(type: Class<T>?): T? {
        if (this.response?.errorBody() == null) {
            return null
        }
        val converter: Converter<ResponseBody?, T> =
            retrofit!!.responseBodyConverter(type!!, arrayOfNulls(0))
        return converter.convert(response.errorBody()!!)
    }

    fun showFriendlyMessage(): String? {
        return if (kind == Kind.HTTP) {
            formatErrorMessage(response, retrofit)
        } else {
            message
        }
    }

    companion object {

        fun httpError(url: String?, response: Response<*>, retrofit: Retrofit?): RetrofitException {
            val message = response.code().toString() + " " + response.message()
            return RetrofitException(
                retrofit = retrofit,
                response = response,
                kind = Kind.HTTP,
                url = url,
                message = message,
                exception = null
            )
        }

        fun networkError(exception: IOException?): RetrofitException {
            val message = "Network error, please try again or check your connection"
            return RetrofitException(
                retrofit = null,
                response = null,
                kind = Kind.NETWORK,
                url = null,
                message = message,
                exception = exception
            )
        }

        fun unexpectedError(exception: Throwable): RetrofitException {
            return RetrofitException(
                retrofit = null,
                response = null,
                kind = Kind.UNEXPECTED,
                url = null,
                exception = exception,
                message = exception.message
            )
        }

        /**
         * Formats the response to the ErrorResponse class
         * The server may return a simple error string or an array of Error objects
         */
        fun formatErrorMessage(response: Response<*>?, retrofit: Retrofit?): String? {
            val errorMsg = "An error has occurred, please try again later."
            try {
                val errorConverter = retrofit!!.responseBodyConverter<ErrorResponse>(
                    ErrorResponse::class.java,
                    ErrorResponse::class.java.annotations
                )
                val error = errorConverter.convert(response?.errorBody()!!)
                return if (error?.error != null) {
                    error.error
                } else error?.message ?: errorMsg
            } catch (exception: EOFException) {
                Timber.e("Couldn't convert exception: $exception")
            } catch (exception: IOException) {
                Timber.e("exception: $exception")
            }
            return errorMsg
        }

    }

}