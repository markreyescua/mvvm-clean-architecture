package com.mcua.architecture.core.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.mcua.architecture.core.base.BaseModel

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    @SerializedName("user_id") val userId: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("type") val type: String,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("number") var number: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("shop_name") var shopName: String? = null,
    @SerializedName("access_token") var accessToken: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("updated_at") val updatedAt: String? = null,
) : BaseModel()