package com.mcua.architecture.framework.model.user

abstract class UserModel {
    abstract val userId: String
    abstract val username: String
    abstract val email: String
    abstract val type: String
    abstract var firstName: String
    abstract var lastName: String
    abstract var number: String?
    abstract var address: String?
    abstract var shopName: String?
    abstract val accessToken: String?
}