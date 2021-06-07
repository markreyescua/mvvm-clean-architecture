package com.mcua.architecture.framework.source

import com.mcua.architecture.framework.data.user.UserResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    companion object {
        const val CREATE_ACCOUNT = "auth/create"
        const val LOGIN_ACCOUNT = "auth/login"
        const val CREATE_PRODUCT = "products/create"
        const val GET_SINGLE_PRODUCT = "products/get/{productId}"
        const val GET_PRODUCTS = "products/get"
        const val UPDATE_PRODUCT = "products/update"
        const val DELETE_PRODUCT = "products/delete"
        const val ADD_ORDER = "orders/add"
        const val GET_SINGLE_ORDER = "orders/get/{orderId}"
        const val GET_ORDERS = "orders/get"
        const val UPDATE_ORDER = "orders/update"
        const val DELETE_ORDER = "orders/delete"
    }

    @FormUrlEncoded
    @POST(CREATE_ACCOUNT)
    suspend fun createAccount(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("type") type: String,
    ): UserResponse

}