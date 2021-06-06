package com.mcua.architecture.base

import com.google.gson.Gson

abstract class BaseModel {

    abstract val id: Int
    abstract var createdAt: String?
    abstract var updatedAt: String?

    fun toJsonString(): String {
        return Gson().toJson(this)
    }
    
}