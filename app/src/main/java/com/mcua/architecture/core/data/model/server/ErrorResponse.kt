package com.mcua.architecture.core.data.model.server

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("message") val message: String? = "Unknown error"
)