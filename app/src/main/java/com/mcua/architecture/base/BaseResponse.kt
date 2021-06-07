package com.mcua.architecture.base

import com.google.gson.Gson

abstract class BaseResponse {

    abstract val message: String?
    abstract val error: String?

    fun toJsonString(): String {
        return Gson().toJson(this)
    }

}