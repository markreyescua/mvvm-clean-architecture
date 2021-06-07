package com.mcua.architecture.framework.data.user

abstract class UserModel {
    abstract val userId: String
    abstract val username: String
    abstract val email: String
    abstract val type: String
    abstract var firstName: String
    abstract var lastName: String
}