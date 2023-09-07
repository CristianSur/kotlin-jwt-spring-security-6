package com.example.sample.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Entity
@Table(name = "users")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int = 0,

    @Column(name = "email", length = Integer.MAX_VALUE)
    var email: String = "",

    @Column(name = "username", length = Integer.MAX_VALUE)
    private var username: String = "",

    @Column(name = "password", length = Integer.MAX_VALUE)
    private var password: String = "",

    @Size(max = 20)
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20)
    var role: RoleEnum = RoleEnum.USER

) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(this.role.name))
    }

    override fun getPassword(): String {
        return this.password
    }

    override fun getUsername(): String {
        return this.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}

enum class RoleEnum {
    USER, ADMIN
}