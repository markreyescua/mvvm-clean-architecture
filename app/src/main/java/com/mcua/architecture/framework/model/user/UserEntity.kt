package com.mcua.architecture.framework.model.user

data class UserEntity(
    override val userId: String,
    override val username: String,
    override val email: String,
    override val type: String,
    override var firstName: String,
    override var lastName: String,
    override var number: String? = null,
    override var address: String? = null,
    override var shopName: String? = null,
    override val accessToken: String? = null,
) : UserModel()