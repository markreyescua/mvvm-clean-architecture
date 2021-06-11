package com.mcua.architecture.core.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mcua.architecture.core.base.Resource
import com.mcua.architecture.core.data.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun getUser(username: String): Resource<User>

    @Query("DELETE FROM users WHERE username = :username")
    suspend fun deleteUser(username: String)

}