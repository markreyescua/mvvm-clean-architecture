package com.mcua.architecture.framework.data.user

import com.google.gson.annotations.SerializedName
import com.mcua.architecture.base.BaseResponse

data class UserResponse(
    override val message: String?,
    override val error: String?,
    @SerializedName("result") val user: User
) : BaseResponse()