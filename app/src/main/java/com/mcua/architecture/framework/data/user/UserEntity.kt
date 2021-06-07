package com.mcua.architecture.framework.data.user

data class UserEntity(
    override val userId: String,
    override val username: String,
    override val email: String,
    override val type: String,
    override var firstName: String,
    override var lastName: String,
) : UserModel()