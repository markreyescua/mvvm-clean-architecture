package com.mcua.architecture.core.base

data class BaseResponse<T>(
    val data: T? = null,
    val message: String? = null
)