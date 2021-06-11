package com.mcua.architecture.framework.data

import com.mcua.architecture.framework.model.User
import com.mcua.architecture.util.network.Resource
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    companion object {
        const val CREATE_USER = "auth/create"
        const val LOGIN_USER = "auth/login"
        const val GET_USER = "auth/profile"
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

    @GET(GET_USER)
    suspend fun getUser(): Resource<User>

    @FormUrlEncoded
    @POST(CREATE_USER)
    suspend fun createUser(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("type") type: String,
    ): Resource<User>

    @FormUrlEncoded
    @POST(LOGIN_USER)
    suspend fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Resource<User>

}