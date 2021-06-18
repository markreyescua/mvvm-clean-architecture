package com.mcua.architecture.core.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mcua.architecture.core.data.model.User

object Converters {

    var gson = Gson()

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

    @TypeConverter
    @JvmStatic
    fun stringToUserToken(data: String?): User.Token? {
        if (data == null) {
            return User.Token("", "", 0L)
        }
        val type = object : TypeToken<User.Token>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    @JvmStatic
    fun userTokenToString(userToken: User.Token?): String {
        return gson.toJson(userToken)
    }

}