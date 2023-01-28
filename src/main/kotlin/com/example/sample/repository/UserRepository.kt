package com.example.sample.repository

import com.example.sample.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): UserEntity

    fun findByUsernameOrEmail(username: String, email: String): UserEntity?
}
