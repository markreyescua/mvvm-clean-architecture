package com.mcua.architecture.core.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

    private var gson = Gson()

    @TypeConverter
    fun stringToListOfString(data: String?): List<String> {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listOfStringToString(items: List<String?>?): String {
        return gson.toJson(items)
    }

}