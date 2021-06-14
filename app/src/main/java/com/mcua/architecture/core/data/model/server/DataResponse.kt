package com.mcua.architecture.core.data.model.server

data class DataResponse<T>(
    val data: T? = null,
    val message: String? = null
)