package com.elliotledger.jirastub.services

import com.elliotledger.jirastub.dataclasses.User

class JiraServices {
    fun getUser(username: String): User {
        return User(
            key = username,
            name = username,
            emailAddress = "tfoxbridge@gmail.com",
            avatarUrls = mapOf(
                "48x48" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
                "24x24" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
                "16x16" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
                "32x32" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg"
            ),
            displayName = "Tony Foxbridge",
            active = true
        )
    }
}