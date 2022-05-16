package com.example.koksharovconsult

data class login(val token :Int) {
    companion object login {
        var userToken: Int? = null
    }
}
