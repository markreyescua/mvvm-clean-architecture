package com.mcua.architecture.framework.model.user

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_id") override val userId: String,
    @SerializedName("username") override val username: String,
    @SerializedName("email") override val email: String,
    @SerializedName("type") override val type: String,
    @SerializedName("first_name") override var firstName: String,
    @SerializedName("last_name") override var lastName: String,
    @SerializedName("number") override var number: String? = null,
    @SerializedName("address") override var address: String? = null,
    @SerializedName("shop_name") override var shopName: String? = null,
    @SerializedName("access_token") override var accessToken: String? = null,
) : UserModel() {

    val password: String? = null

    @SerializedName("created_at")
    val createdAt: String? = null

    @SerializedName("updated_at")
    val updatedAt: String? = null

    fun toJsonString(): String {
        return Gson().toJson(this)
    }
}