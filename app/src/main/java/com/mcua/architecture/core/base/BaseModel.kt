package com.mcua.architecture.core.base

import com.google.gson.Gson

abstract class BaseModel {
    fun toJsonString(): String {
        return Gson().toJson(this)
    }
}