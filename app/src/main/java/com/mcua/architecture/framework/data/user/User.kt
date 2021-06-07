package com.mcua.architecture.framework.data.user

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_id") override val userId: String,
    @SerializedName("username") override val username: String,
    @SerializedName("email") override val email: String,
    @SerializedName("type") override val type: String,
    @SerializedName("first_name") override var firstName: String,
    @SerializedName("last_name") override var lastName: String,
) : UserModel() {

    @SerializedName("created_at")
    val createdAt: String? = ""
    @SerializedName("updated_at")
    val updatedAt: String? = ""

    fun toJsonString(): String {
        return Gson().toJson(this)
    }
}